package com.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.User;
import com.exception.InvalidPasswordException;
import com.exception.UserNotFoundException;
import com.service.LoginService;
import com.service.LoginServiceImpl;

@RestController
@RequestMapping("/login")
public class LoginController {
	
	public static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private LoginServiceImpl loginService;
	
	@PostMapping("/verify")
	public User verifyLogin(@RequestBody User user) throws UserNotFoundException, InvalidPasswordException
	{
		logger.info("Initiated login verification");
		String username = user.getUsername();
		String password = user.getPassword();
		return loginService.verifyCredentials(username, password);
	}
	
	@GetMapping("/getusers")
	public List<User> getAllUsers()
	{
		logger.info("fetching all users");
		return loginService.getAllUsers();
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/admin")
	public String adminRequest()
	{
		return "Admin verified";
	}
//	
//	@HystrixCommand(fallbackMethod="fallback_method" ,commandProperties = {
//			@HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="2000")
//	})
//	public String hystrixDummyMethod() throws InterruptedException
//	{
//		Thread.sleep(4000);
//		return "SUCCESS";
//	}
//	
//	public void fallback_method()
//	{
//		logger.error("Request timeout fallback!");
//	}

}
