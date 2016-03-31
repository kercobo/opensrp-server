package org.opensrp.rest.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.json.JSONObject;
import org.opensrp.dto.register.HHRegisterDTO;
import org.opensrp.dto.register.HHRegisterEntryDTO;
import org.opensrp.rest.repository.LuceneHouseHoldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.github.ldriscoll.ektorplucene.LuceneResult;
import com.github.ldriscoll.ektorplucene.LuceneResult.Row;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@Service
public class LuceneHouseHoldService {

	private LuceneHouseHoldRepository luceneHouseHoldRepository;

	@Autowired
	public LuceneHouseHoldService(
			LuceneHouseHoldRepository luceneHouseHoldRepository) {
		this.luceneHouseHoldRepository = luceneHouseHoldRepository;
	}

	public HHRegisterDTO findLuceneResult(MultiValueMap<String, String> queryParameters) throws JsonParseException, JsonMappingException,
			IOException {
		ObjectMapper mapper = new ObjectMapper();
		// mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
		// false);
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		mapper.setVisibilityChecker(VisibilityChecker.Std.defaultInstance()
				.withFieldVisibility(JsonAutoDetect.Visibility.ANY));
		Map<String, String> preparedParameters = prepareParameters(queryParameters);
		String makeQueryString = "";
		int paramCounter = 1;
		for(Entry<String, String> entry : preparedParameters.entrySet())
		{
			makeQueryString+=entry.getKey()+":"+entry.getValue();
			
			if(preparedParameters.size()>paramCounter)
				makeQueryString+=" AND ";
			
			paramCounter++;
		}
		
		LuceneResult luceneResult = luceneHouseHoldRepository
				.findDocsByProvider(makeQueryString);
		List<Row> rows = luceneResult.getRows();
		List<HHRegisterEntryDTO> hhRegisterEntryDTOList = new ArrayList<HHRegisterEntryDTO>();

		for (Row row : rows) {
			LinkedHashMap<String, Object> fields = row.getFields();
			String jsonString = new JSONObject(fields).toString();
			hhRegisterEntryDTOList.add(mapper.readValue(jsonString.getBytes(),
					HHRegisterEntryDTO.class));
		}
		return new HHRegisterDTO(hhRegisterEntryDTOList);
	}

	private Map<String, String> prepareParameters(MultiValueMap<String, String> queryParameters) {

		Map<String, String> parameters = new HashMap<String, String>();

		Iterator<String> it = queryParameters.keySet().iterator();

		while (it.hasNext()) {
			String theKey = (String) it.next();
			parameters.put(theKey, queryParameters.getFirst(theKey));
		}

		return parameters;

	}
}