package com;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.security.SecurityConfig;

@SpringBootApplication
public class LoginApiApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(LoginApiApplication.class, args);
//		Arrays.asList(context.getBeanDefinitionNames()).stream().forEach(System.out::println);
	}

}
