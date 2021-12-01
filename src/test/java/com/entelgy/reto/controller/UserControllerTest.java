package com.entelgy.reto.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.entelgy.reto.service.UserService;

@WebMvcTest(UserController.class)
public class UserControllerTest {

	@MockBean
	private UserService userService;
	
	@Autowired
	MockMvc mockMvc;
	
	@Value("${url}")
	private String url;	
	
	@Test
	void getData() throws Exception {
		mockMvc.perform(post(url)).andExpect(status().isOk());			
	}
	
}
