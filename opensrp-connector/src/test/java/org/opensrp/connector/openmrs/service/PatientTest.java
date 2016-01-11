package org.opensrp.connector.openmrs.service;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.opensrp.api.domain.Address;
import org.opensrp.api.domain.BaseEntity;
import org.opensrp.api.domain.Client;
import org.opensrp.domain.Multimedia;
import org.opensrp.repository.MultimediaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;


public class PatientTest extends TestResourceLoader{
	PatientService s;
	@Mock
	MultimediaRepository multimediaRepository;

	public PatientTest() throws IOException {
		super();
	}
	
	@Before
	public void setup(){
		s = new PatientService(openmrsOpenmrsUrl, openmrsUsername, openmrsPassword);
	}
	
	@Test
	public void shouldCreatePerson() throws JSONException {
		List<Address> addresses = new ArrayList<>();
		addresses.add(new Address("BIRTH", new Date(), new Date(), null, "LAT", "LON", "PCODE", "SINDH", "PK"));
		addresses.add(new Address("DEATH", new Date(), new Date(), null, "LATd", "LONd", "dPCODE", "KPK", "PK"));
		Map<String, Object> attribs = new HashMap<>();
		attribs.put("Household ID", "HH112");
		Client c = new Client()
			.withBaseEntity(new BaseEntity(UUID.randomUUID().toString(), "FN", "MN", "LN", new Date(), new Date(), 
					true, false, "MALE", addresses , attribs ))
			.withIdentifier("Birth Reg Num", "b-8912819"+new Random().nextInt(99))
			.withIdentifier("Death Reg Num", "d-ewj-js3u2"+new Random().nextInt(99));
		//System.out.println(s.createPatient(c));
	}
	
	@Test
	public void shouldUploadFile() throws IOException
	{
		/* File file = new File("/home/user/Documents/image.jpeg");
		 DiskFileItem fileItem = new DiskFileItem("file", "image/jpeg", false, file.getName(), (int) file.length() , file.getParentFile());
		 fileItem.getOutputStream();
		 
		 FileInputStream input = new FileInputStream(file);
		 MultipartFile multipartFile = new MockMultipartFile("file",
		            file.getName(), "image/jpeg", IOUtils.toByteArray(input));*/
		 
		// MultipartFile multipartFile = new CommonsMultipartFile(fileItem);
		// Multimedia multimedia =   multimediaRepository.findByCaseId("4237d267-d438-49f2-9422-8968t555447c");
		// s.patientImageUpload(multimedia);
		 
	}
}
