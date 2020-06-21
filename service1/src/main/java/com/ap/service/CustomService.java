package com.ap.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ap.configuration.ApplicationProperties;
import com.ap.constant.URIResource;
import com.ap.controller.Service1Controller;
import com.ap.exception.CustomException;
import com.ap.model.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class CustomService {
	Logger logger = LoggerFactory.getLogger(CustomService.class);
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private ApplicationProperties applicationProperties;
	private ObjectMapper mapper = new ObjectMapper();
	
	public String getService2Response(String uuid) {
		logger.info("getService2Response() called with UUID : "+uuid); 
		logger.info("host : "+applicationProperties.getService2Host());
		ResponseEntity<String> res = restTemplate.getForEntity(applicationProperties.getService2Host()+"/"+URIResource.GET_SERVICE2_DETAIL+"/"+uuid, String.class);
		String detail = getDetails(uuid);
		return res.getBody()+" "+detail;
		
	}
	
	public String getDetails(String uuid) {
		logger.info("Service2 getDetails() method called with UUID : "+uuid);
		String req = null;
		Person payload = new Person();
		try {
		 req = mapper.writeValueAsString(payload);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<>(req.toString(),header);
		ResponseEntity<Person> response = restTemplate.postForEntity(applicationProperties.getService3Host()+"/"+URIResource.GET_SERVICE3_DETAIL+"/"+uuid, entity, Person.class);
		if(response.getStatusCodeValue()!=200) {
			throw new CustomException(response.getBody().toString());
		}
		Person person = response.getBody();
		logger.info("Person : "+person);
		return person.getName()+" "+person.getSurname();
		
	}

}
