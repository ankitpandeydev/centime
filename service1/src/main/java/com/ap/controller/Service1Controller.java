package com.ap.controller;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ap.service.CustomService;

@RestController
public class Service1Controller {
	Logger logger = LoggerFactory.getLogger(Service1Controller.class);
	@Autowired
	private CustomService customService;

	@GetMapping("/howiam")
	public String getAppStatus() {
		UUID uuid = UUID.randomUUID();
		return "up";
	}

	@PostMapping
	public String details() {
		UUID uuid = UUID.randomUUID();
		String response = customService.getService2Response(uuid.toString());
		return response;
	}

}
