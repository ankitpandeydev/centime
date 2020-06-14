package com.ap.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ap.service.CustomService;

@RestController
public class Service2Controller {
	Logger logger = LoggerFactory.getLogger(Service2Controller.class);
	@Autowired
	private CustomService customService;
	
	
	@GetMapping("/details/{uuid}")
	public String details(@PathVariable String uuid) {
		logger.info("Service3 details() resource called for UUID : "+uuid);
		String response = customService.getDetails(uuid);
		return response;
		
	}
	

}
