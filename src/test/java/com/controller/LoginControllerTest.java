package com.controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.LoginServiceImpl;

@WebMvcTest(LoginController.class)
@WebAppConfiguration
@ExtendWith(MockitoExtension.class)
public class LoginControllerTest {

	@Autowired
	private WebApplicationContext wac;

	@Mock
	private MockMvc mvc;
	
	@InjectMocks
	private LoginController loginController;
	
	@Mock
	private LoginServiceImpl loginServiceImpl;
		
	
	@BeforeEach
	public void setup()
	{
		this.mvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}
	
	@Test
	public void verifyTest() throws Exception
	{
		com.entity.User user = new com.entity.User();
		user.setUsername("rajdeepj1363@gmail.com");
		user.setPassword("12345");
		ObjectMapper obj = new ObjectMapper();
		String body = obj.writeValueAsString(user);
		MvcResult result = mvc.perform(MockMvcRequestBuilders.post("/login/verify")
				.accept(org.springframework.http.MediaType.APPLICATION_JSON)
				.content(body))
				.andReturn();
		
		int status = result.getResponse().getStatus();
		System.out.println("Status: "+status);
		assertNotNull(status);
	}
}
