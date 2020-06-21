package com.ap.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ap.configuration.ApplicationProperties;
import com.ap.constant.URIResource;
import com.ap.controller.Service2Controller;
import com.ap.model.Person;

@Service
public class CustomService {
	Logger logger = LoggerFactory.getLogger(CustomService.class);
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private ApplicationProperties applicationProperties;
	
	public String getDetails(String uuid) {
		logger.info("Service2 getDetails() method called with UUID : "+uuid);
	
		return "Hello ";
		
	}
	

}
