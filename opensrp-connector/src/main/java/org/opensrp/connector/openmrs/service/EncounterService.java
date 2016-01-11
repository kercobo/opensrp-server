package org.opensrp.connector.openmrs.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.opensrp.api.domain.Event;
import org.opensrp.api.domain.Obs;
import org.opensrp.common.util.HttpResponse;
import org.opensrp.connector.HttpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysql.jdbc.StringUtils;

@Service
public class EncounterService extends OpenmrsService{
	private static final String ENCOUNTER_URL = "ws/rest/v1/encounter";
	private static final String ENCOUNTER__TYPE_URL = "ws/rest/v1/encountertype";
	private PatientService patientService;
	private OpenmrsUserService userService;

	@Autowired
	public EncounterService(PatientService patientService, OpenmrsUserService userService) {
		this.patientService = patientService;
		this.userService = userService;
	}
	
	public EncounterService(String openmrsUrl, String user, String password) {
    	super(openmrsUrl, user, password);
	}
	
	public PatientService getPatientService() {
		return patientService;
	}

	public void setPatientService(PatientService patientService) {
		this.patientService = patientService;
	}

	public OpenmrsUserService getUserService() {
		return userService;
	}

	public void setUserService(OpenmrsUserService userService) {
		this.userService = userService;
	}

	public JSONObject createEncounter(Event e) throws JSONException{
		JSONObject pt = patientService.getPatientByIdentifier(e.getBaseEntityId());
		JSONObject enc = new JSONObject();
		JSONObject pr = userService.getPersonByUser(e.getProviderId());
		
		enc.put("encounterDatetime", OPENMRS_DATE.format(e.getEventDate()));
		// patient must be existing in OpenMRS before it submits an encounter. if it doesnot it would throw NPE
		if (pr.getString("uuid").isEmpty() || pr.getString("uuid")==null)
			System.out.println("Person or Patient does not exist or empty inside openmrs with identifier: " + pr.getString("uuid"));
		else 
			enc.put("patient", pt.getString("uuid"));
		enc.put("encounterType", e.getEventType());
		enc.put("location", e.getLocationId());
		if (pr.getString("uuid").isEmpty() || pr.getString("uuid")==null)
			System.out.println("Person or Patient does not exist or empty inside openmrs with identifier: " + pr.getString("uuid"));
		else 
			enc.put("provider", pr.getString("uuid"));

		List<Obs> ol = e.getObs();
		Map<String, JSONObject> p = new HashMap<>();
		Map<String, List<JSONObject>> pc = new HashMap<>();
		
		for (Obs obs : ol) {
			//if no parent simply make it root obs
			if(StringUtils.isEmptyOrWhitespaceOnly(obs.getParentCode())){
				p.put(obs.getFieldCode(), convertObsToJson(obs));
			}
			else {
				//find parent obs if not found search and fill or create one
				JSONObject parentObs = p.get(obs.getParentCode());
				if(parentObs == null){
					p.put(obs.getParentCode(), convertObsToJson(getOrCreateParent(ol, obs)));
				}
				// find if any other exists with same parent if so add to the list otherwise create new list
				List<JSONObject> obl = pc.get(obs.getParentCode());
				if(obl == null){
					obl = new ArrayList<>();
				}
				obl.add(convertObsToJson(obs));
				pc.put(obs.getParentCode(), obl);
			}
		}
		
		JSONArray obar = new JSONArray();
		for (String ok : p.keySet()) {
			JSONObject obo = p.get(ok);
			
			List<JSONObject> cob = pc.get(ok);
			if(cob != null && cob.size() > 0) {
				obo.put("groupMembers", new JSONArray(cob));
			}
			
			obar.put(obo);
		}
		enc.put("obs", obar);
		System.out.println("Going to create Encounter: " + enc.toString());
		HttpResponse op = HttpUtil.post(HttpUtil.removeEndingSlash(OPENMRS_BASE_URL)+"/"+ENCOUNTER_URL, "", enc.toString(), OPENMRS_USER, OPENMRS_PWD);
		return new JSONObject(op.body());
	}
	
	private JSONObject convertObsToJson(Obs o) throws JSONException{
		JSONObject obo = new JSONObject();
		obo.put("concept", o.getFieldCode());
		if(o.getValue() != null && !StringUtils.isEmptyOrWhitespaceOnly(o.getValue().toString())) {
			obo.put("value", o.getValue());
		}
		
		return obo;
	}
	
	private Obs getOrCreateParent(List<Obs> obl, Obs o){
		for (Obs obs : obl) {
			if(o.getParentCode().equalsIgnoreCase(obs.getFieldCode())){
				return obs;
			}
		}
		return new Obs("concept", o.getParentCode(), null, null, null, null);
	}
}
