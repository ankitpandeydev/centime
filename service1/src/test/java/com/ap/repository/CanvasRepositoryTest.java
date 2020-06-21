package com.ap.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.ap.entity.Canvas;

@SpringBootTest
class CanvasRepositoryTest {
	
	@MockBean
	private CanvasRepository canvasRepository;

    
    
	@Test
	void testById() {
		Mockito.when(
		canvasRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(new Canvas()));
		Optional<Canvas> opt = canvasRepository.findById(Long.valueOf(1));
		System.out.println(opt.isPresent());
	}

}
