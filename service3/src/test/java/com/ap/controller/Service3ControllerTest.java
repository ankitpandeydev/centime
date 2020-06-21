package com.ap.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

class Service3ControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void greetingShouldReturnMessageFromService() throws Exception {
		
		this.mockMvc.perform(post("/details/123abc")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("up")));
	}

}
