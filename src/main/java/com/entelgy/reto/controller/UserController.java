package com.entelgy.reto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entelgy.reto.model.dto.DataDTO;
import com.entelgy.reto.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<DataDTO> getData(){		
		return new ResponseEntity<DataDTO>(userService.getData(),HttpStatus.OK);
	}

}
