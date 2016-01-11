package org.opensrp.web.controller;
import org.json.JSONException;
import org.opensrp.connector.openmrs.service.OpenmrsDashboardLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

@Controller
@RequestMapping("/dashboard-location/")
public class DashboardLocationController {
private OpenmrsDashboardLocationService openmrsLocationService;
	
	@Autowired
	public DashboardLocationController(OpenmrsDashboardLocationService openmrsLocationService){
		this.openmrsLocationService = openmrsLocationService;		
	}
	
	@RequestMapping("all-location-tree")
	@ResponseBody
	public ResponseEntity <String> getAllLocationTree() throws JSONException {
		return new ResponseEntity<>(new Gson().toJson(openmrsLocationService.getAllLocationTree()),HttpStatus.OK);
	}

}
