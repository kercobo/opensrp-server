package org.opensrp.connector.openmrs.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.opensrp.common.domain.DashboardLocation;
import org.opensrp.common.util.HttpResponse;
import org.opensrp.connector.HttpUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

@Service
public class OpenmrsDashboardLocationService extends OpenmrsService {
	
	private static Logger logger = LoggerFactory.getLogger(OpenmrsDashboardLocationService.class.toString());
	private static final String LOCATION_URL = "ws/rest/v1/location";
	public OpenmrsDashboardLocationService(){
		
	}	
	public JSONObject getAllLocationTree() throws JSONException {
		//LocationTree ltr = new LocationTree();
		List<DashboardLocation> loc = new ArrayList<DashboardLocation>(); 
		int index = 0;
		for(;;){						
			HttpResponse op = HttpUtil.get(HttpUtil.removeEndingSlash(OPENMRS_BASE_URL)+"/"+LOCATION_URL, "v=full&startIndex="+index+"", OPENMRS_USER, OPENMRS_PWD);
			JSONArray res = new JSONObject(op.body()).getJSONArray("results");			
			if(res.length() != 0){
				for (int i = 0; i < res.length(); i++) {					
					DashboardLocation l = new DashboardLocation();
					JSONObject location = res.getJSONObject(i);
					JSONObject obj = new JSONObject(location.toString());					
					ObjectMapper mapper = new ObjectMapper();
					String parentLocation = obj.getString("parentLocation").toString();	
					JSONArray tags = obj.getJSONArray("tags");	
					l.setTag("unknown");
					for (int k = 0; k < tags.length(); k++) {						
						l.setTag(tags.getJSONObject(k).getString("name"));						
					}					
					try {
						JsonNode rootNode = mapper.readTree(parentLocation);
						if(rootNode.isNull() ){
							l.setParent(null);
						}else{
							l.setParent(rootNode.get("name"));
						}						
						
					} catch (JsonProcessingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					l.setName(obj.getString("name"));
					loc.add(l);					
				}
			}
			if(res.length() <50){				
			JSONObject jsonObj = new JSONObject();	
			return jsonObj.put("data", loc);
			}
			index = index+50;			
		}		
	}
}
