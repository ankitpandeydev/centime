package com.ap.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ap.configuration.ApplicationProperties;
import com.ap.constant.URIResource;
import com.ap.controller.Service1Controller;

@Service
public class CustomService {
	Logger logger = LoggerFactory.getLogger(CustomService.class);
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private ApplicationProperties applicationProperties;
	
	public String getService2Response(String uuid) {
		logger.info("getService2Response() called with UUID : "+uuid); 
		logger.info("host : "+applicationProperties.getService2Host());
		String response = restTemplate.getForObject(applicationProperties.getService2Host()+"/"+URIResource.GET_SERVICE2_DETAIL+"/"+uuid, String.class);
		
		return response;
		
	}

}
