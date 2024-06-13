package com.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.entity.User;
import com.exception.InvalidPasswordException;
import com.exception.UserNotFoundException;
import com.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
public class LoginServiceTest {
	

	@Spy
	@InjectMocks
	private LoginService loginService = new LoginServiceImpl();
	
	@Mock
	private UserRepository userRepo;
	
//	@BeforeEach
//	public void setUp()
//	{
//		System.out.println("Hello");
//	}
//	
//	@AfterEach
//	public void close()
//	{
//		System.out.println("Closing tests");
//	}
	
	@BeforeAll
	public static void setUp()
	{
		System.out.println("Hello");
	}
	
	@AfterAll
	public static void close()
	{
		System.out.println("Closing tests");
	}
	
	@Test
	public void verifyCredentialsTest() throws UserNotFoundException, InvalidPasswordException
	{
		User user = new User();
		user.setUsername("rajdeepj1363@gmail.com");
		user.setPassword("12345");
		user.setStatus("LOGGEDOFF");
		Mockito.when(this.userRepo.findById("rajdeepj1363@gmail.com")).thenReturn(Optional.of(user));
		User temp =  loginService.verifyCredentials("rajdeepj1363@gmail.com", "12345");
		verify(loginService,times(1)).verifyCredentials("rajdeepj1363@gmail.com", "12345");
		assertTrue(temp != null);
	}
	
	@Test
	public void verifyCredentialsUserNotFoundTest() throws UserNotFoundException, InvalidPasswordException
	{
		User user = new User();
		user.setUsername("rajdeepj13633@gmail.com");
		user.setPassword("12345");
		user.setStatus("LOGGEDOFF");
		lenient().when(this.userRepo.findById("rajdeepj13633@gmail.com")).thenReturn(Optional.of(user));
		assertThrows(UserNotFoundException.class,()->loginService.verifyCredentials("rajdeepj1363@gmail.com", "12345"),"User not found exception");
		
	}
	
	@Test
	public void test123()
	{
		assertTrue(true);
	}
}
