package com.ap.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.ap.service.CustomService;

@WebMvcTest(Service2Controller.class)
class Service2ControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private CustomService customService;

	@Test
	public void applicationStatusTest() throws Exception {
		
		Mockito.when(
				customService.getDetails(Mockito.anyString())).thenReturn("{\"Hello John Doe\"}");
		
		this.mockMvc.perform(get("/details/"+"adfa1212")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("Hello John Doe")));
	}
	

}
