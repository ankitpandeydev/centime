package com.ap.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.ap.service.CustomService;


@WebMvcTest(Service1Controller.class)
class Service1ControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private CustomService customService;

	@Test
	public void applicationStatusTest() throws Exception {
		
		this.mockMvc.perform(get("/howiam")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("up")));
	}
	
	@Test
	public void details() throws Exception {
		Mockito.when(
				customService.getService2Response(Mockito.anyString())).thenReturn("{\"Hello John Doe\"}");
		this.mockMvc.perform(post("/").contentType(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("{\"Hello John Doe\"}")));
	}
}
