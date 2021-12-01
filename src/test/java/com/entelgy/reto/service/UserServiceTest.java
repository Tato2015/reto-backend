package com.entelgy.reto.service;


import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.entelgy.reto.RetoBackendApplication;
import com.entelgy.reto.model.dto.DataDTO;
import com.entelgy.reto.service.impl.UserServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RetoBackendApplication.class)
public class UserServiceTest {
	
	@Mock
	private RestTemplate restTemplate;

	@InjectMocks
	private UserServiceImpl userService = new UserServiceImpl();

	@Value("${url}")
	private String url;	
	
	@Test
	public void getData() throws Exception {
		DataDTO dataDto = new DataDTO();
		Mockito
        .when(restTemplate.getForEntity(url, DataDTO.class))
        .thenReturn(new ResponseEntity<DataDTO>(dataDto, HttpStatus.OK));

		assertNotNull(dataDto);
		
	}

}
