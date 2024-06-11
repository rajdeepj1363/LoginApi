package com.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.User;
import com.exception.InvalidPasswordException;
import com.exception.UserNotFoundException;
import com.repository.UserRepository;
import com.utils.LoginConstants;

@Service
public class LoginServiceImpl implements LoginService {
	
	public static final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);
	
	@Autowired
	private UserRepository userRepo;
	
	@Override
	public User verifyCredentials(String username, String password) throws UserNotFoundException, InvalidPasswordException
	{
		logger.info("Username: {}, Password: {}",username,password);
		User user = null;
		user = userRepo.findById(username).orElseThrow(()->new UserNotFoundException("Invalid username provided"));
		if(user.getPassword().equals(password))
		{
			user.setStatus(LoginConstants.SESSION_LOGGEDIN);
			userRepo.save(user);
			logger.info("Login successful");
			return user;
		}
		else
		{
			logger.error("Invalid password");
			throw new InvalidPasswordException("Provided password is invalid");
		}
	}
	
	public boolean logoutUser(String username)
	{
		User user = userRepo.findById(username).orElse(null);
		if(user == null)
		{
			logger.error("No such user found for logging out");
			return true; //initiate logout
		}
		else
		{
			user.setStatus(LoginConstants.SESSION_LOGGEDOUT);
			logger.info("Logging out...");
			return true;
		}
	}
	
	public List<User> getAllUsers()
	{
		return userRepo.findAll();
	}
}
