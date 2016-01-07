package org.opensrp.connector.openmrs.service;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.opensrp.api.domain.User;
import org.opensrp.common.util.HttpResponse;
import org.opensrp.connector.HttpUtil;
import org.springframework.stereotype.Service;

@Service
public class OpenmrsUserService extends OpenmrsService{

	private static final String AUTHENTICATION_URL = "ws/rest/v1/session";
	private static final String USER_URL = "ws/rest/v1/user";
	private static final String PERSON_URL = "ws/rest/v1/person";
	private static final String TEAM_MEMBER_URL = "ws/rest/v1/teammodule/member";
	private static final String TEAM_MEMBER_LOCATION_URL = "ws/rest/v1/teammodule/memberLocation";
	
    public OpenmrsUserService() { }

    public OpenmrsUserService(String openmrsUrl, String user, String password) {
    	super(openmrsUrl, user, password);
    }

	public boolean authenticate(String username, String password) throws JSONException {
		HttpResponse op = HttpUtil.get(HttpUtil.removeEndingSlash(OPENMRS_BASE_URL)+"/"+AUTHENTICATION_URL, "", username, password);
		return new JSONObject(op.body()).getBoolean("authenticated");
	}

	public User getUser(String username) throws JSONException {
		HttpResponse op = HttpUtil.get(HttpUtil.removeEndingSlash(OPENMRS_BASE_URL)+"/"+USER_URL, "v=full&username="+username, OPENMRS_USER, OPENMRS_PWD);
		JSONArray res = new JSONObject(op.body()).getJSONArray("results");
		if(res.length() == 0){
			return null;
		}
		JSONObject obj = res.getJSONObject(0);
		JSONObject p = obj.getJSONObject("person");
		User u = new User(obj.getString("uuid"), obj.getString("username"), null, null,
				p.getString("display"), "", "", null, null, p.getString("gender"));
		//Object ploc;
		JSONArray a = p.getJSONArray("attributes");
		
		for (int i = 0; i < a.length(); i++) {
			String ad = a.getJSONObject(i).getString("display");
			u.getBaseEntity().addAttribute(ad.substring(0,ad.indexOf("=")-1), ad.substring(ad.indexOf("=")+2));
		}
		
		JSONArray per = obj.getJSONArray("privileges");
		
		for (int i = 0; i < per.length(); i++) {
			u.addPermission(per.getJSONObject(i).getString("name"));
		}
		
		JSONArray rol = obj.getJSONArray("roles");
		
		for (int i = 0; i < rol.length(); i++) {
			u.addRole(rol.getJSONObject(i).getString("name"));
		}
		
		u.getBaseEntity().addAttribute("_PERSON_UUID", p.getString("uuid"));
		return u;
	}
	public List<String> getAllUsers() throws JSONException {
		List<String> users = new ArrayList<>();
		int index = 0;
		for(;;){
			HttpResponse op = HttpUtil.get(HttpUtil.removeEndingSlash(OPENMRS_BASE_URL)+"/"+USER_URL, "startIndex="+index+"", OPENMRS_USER, OPENMRS_PWD);
			JSONArray res = new JSONObject(op.body()).getJSONArray("results");
			for(int i=0; i<res.length();i++)
			{
				users.add(res.getJSONObject(i).getString("display"));
			}
			if(res.length() <50){
				return users;
			}
			index = index+50;
		}
	}
	public JSONObject getPersonByUser(String username) throws JSONException {
		HttpResponse op = HttpUtil.get(HttpUtil.removeEndingSlash(OPENMRS_BASE_URL)+"/"+USER_URL, "v=full&username="+username, OPENMRS_USER, OPENMRS_PWD);
		JSONArray res = new JSONObject(op.body()).getJSONArray("results");
		if(res.length() == 0){
			return null;
		}
		JSONObject obj = res.getJSONObject(0);
		JSONObject p = obj.getJSONObject("person");
		return p;
	}
	
	public JSONObject getTeamMember(String uuid) throws JSONException{
		HttpResponse op = HttpUtil.get(HttpUtil.removeEndingSlash(OPENMRS_BASE_URL)+"/"+TEAM_MEMBER_URL+"/"+uuid, "v=full", OPENMRS_USER, OPENMRS_PWD);
		return new JSONObject(op.body());
	}
	public JSONObject getTeamMemberByLocation(String location) throws JSONException{
		
		//HttpResponse opPerson = HttpUtil.get(HttpUtil.removeEndingSlash(OPENMRS_BASE_URL)+"/"+USER_URL, "v=full&uuid=23f56e82-ed2b-433a-8cad-de42b94c39e6", OPENMRS_USER, OPENMRS_PWD);
		HttpResponse op = HttpUtil.get(HttpUtil.removeEndingSlash(OPENMRS_BASE_URL)+"/"+TEAM_MEMBER_LOCATION_URL, "q="+location+"&v=full", OPENMRS_USER, OPENMRS_PWD);
		return new JSONObject(op.body());
	}
}
