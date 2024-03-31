package com.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.User;
import com.exception.UserNotFoundException;
import com.service.LoginService;

@RestController
@RequestMapping("/login")
public class LoginController {
	
	public static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private LoginService loginService;
	
	@GetMapping("/verify")
	public User verifyLogin(@RequestBody User user) throws UserNotFoundException
	{
		logger.info("Initiated login verification");
		String username = user.getUsername();
		String password = user.getPassword();
		return loginService.verifyCredentials(username, password);
	}
}
