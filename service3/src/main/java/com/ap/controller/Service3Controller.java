package com.ap.controller;



import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ap.exception.ServiceException;
import com.ap.model.Person;
import com.ap.service.CustomService;

@RestController
public class Service3Controller {
	Logger logger = LoggerFactory.getLogger(Service3Controller.class);
	
	@Autowired
	private CustomService customService;
	
	@PostMapping(path = "/details/{uuid}")
	public ResponseEntity<Person> details(@PathVariable String uuid,  @RequestBody Person per) throws ServiceException{
		logger.info("Service3 details() resource called with UUID : "+uuid);
	    if(!validate(per)) {
	    	throw new ServiceException("Person json is not valid.");
	    }
		Person person = customService.getDetails(uuid);
		
		return new ResponseEntity<Person>( person, HttpStatus.OK);
		
	}
	
	private boolean validate(Person person) {
		
		return ((person.getName()!=null) && (person.getSurname()!=null));
	}
	
	

}
