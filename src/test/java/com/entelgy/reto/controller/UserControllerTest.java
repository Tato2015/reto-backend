package com.entelgy.reto.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.entelgy.reto.model.dto.DataDTO;
import com.entelgy.reto.model.dto.UserDTO;
import com.entelgy.reto.service.UserService;

@WebMvcTest(UserController.class)
public class UserControllerTest {

	@MockBean
	private UserService userService;
	
	@Autowired
	MockMvc mockMvc;
	
	
	@Test
	void getData() throws Exception {
		DataDTO dataDto = new DataDTO();
		List<UserDTO> users = new ArrayList<>();
		UserDTO userDto = new UserDTO();
		userDto.setId("1");
		userDto.setFirstName("George");
		userDto.setLastName("Bluth");
		userDto.setEmail("george.bluth@reqres.in");
		users.add(userDto);
		dataDto.setUsers(users);
		when(userService.getData()).thenReturn(dataDto);
		this.mockMvc.perform(post("/api/users")).andDo(print()).andExpect(status().isOk());					
	}
	
}
