package com.ap.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ap.entity.Canvas;
import com.ap.model.CanvasPojo;
import com.ap.service.CanvasService;

@RestController
@RequestMapping("/canvas")
public class CanvasController {
	
	
	@Autowired
	CanvasService canvasService;
	
	@GetMapping("/{id}")
	public Canvas getById(@PathVariable Long id) throws Exception {
		
		return canvasService.findById(id);
	}
	
	@GetMapping("/all")
	public List<Canvas> getById() {
		
		return canvasService.findAll();
	}
	
	@GetMapping("/nestedList")
	public List<CanvasPojo> getNestResponse() {
		
		return canvasService.getNestResponse();
	}

}
