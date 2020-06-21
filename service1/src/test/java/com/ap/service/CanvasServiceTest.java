package com.ap.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ap.entity.Canvas;
import com.ap.repository.CanvasRepository;

@SpringBootTest
class CanvasServiceTest {
    
	
	@Autowired
	private CanvasRepository canvasRepository;

	
	@Test
	void testFindAll() {
		Iterable<Canvas> it = canvasRepository.findAll();
		List<Canvas> list = StreamSupport.stream(it.spliterator(), false).collect(Collectors.toList());
		assertNotNull(list);
		assertTrue(list.size()>0);
	}
	
	@Test
	void testFindById() {
		Optional<Canvas> option = canvasRepository.findById(Long.valueOf(1));
		assertNotNull(option.get());
		assertTrue(option.isPresent());
	}
	
	@Test
	void testNestedResponse() {
		Iterable<Canvas> it = canvasRepository.findAll(); 
		List<Canvas> list = StreamSupport.stream(it.spliterator(), false).collect(Collectors.toList());
		assertNotNull(list);
		assertTrue(list.size()>0);
	}



}
