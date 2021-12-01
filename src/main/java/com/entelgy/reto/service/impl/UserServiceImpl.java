package com.entelgy.reto.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.entelgy.reto.model.dto.DataDTO;
import com.entelgy.reto.model.dto.FormDTO;
import com.entelgy.reto.model.dto.UserDTO;
import com.entelgy.reto.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${url}")
	private String url;
	
	@Override
	public DataDTO getData() {
		ResponseEntity<FormDTO> response =
                restTemplate.getForEntity(url,FormDTO.class);
			  FormDTO formDto = response.getBody();
              List<UserDTO> users = formDto.getUsers();
              DataDTO dataDto = new DataDTO();
              dataDto.setUsers(users);
		return dataDto;
	}

}
