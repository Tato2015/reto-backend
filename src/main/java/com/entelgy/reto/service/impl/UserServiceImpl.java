package com.entelgy.reto.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
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
         HttpHeaders headers = new HttpHeaders();
         headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
         headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
         HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

         ResponseEntity<FormDTO> formDto= restTemplate.exchange(url, HttpMethod.GET,entity,FormDTO.class);
         List<UserDTO> users = formDto.getBody().getUsers();
         DataDTO dataDto = new DataDTO();
         dataDto.setUsers(users);
		
		return dataDto;
	}

}
