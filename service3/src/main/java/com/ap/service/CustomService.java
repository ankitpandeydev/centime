package com.ap.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ap.controller.Service3Controller;
import com.ap.model.Person;

@Service
public class CustomService {
	Logger logger = LoggerFactory.getLogger(CustomService.class);
	
	public Person getDetails(String uuid) {
		logger.info("Service3 getDetails() resource called with UUID : "+uuid); 
		//ResponseEntity<Person> response = restTemplate.postForEntity(applicationProperties.getService2Host()+"/"+URIResource.GET_SERVICE3_DETAIL+"/"+uuid, null, Person.class);
		Person person = new Person();
		person.setName("John");
		person.setSurname("Doe");
		return person;
		
	}
	

}
