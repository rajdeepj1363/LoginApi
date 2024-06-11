package com.service;

import java.util.List;

import com.entity.User;
import com.exception.InvalidPasswordException;
import com.exception.UserNotFoundException;

public interface LoginService {
	
	public User verifyCredentials(String username, String password) throws UserNotFoundException, InvalidPasswordException;
	public List<User> getAllUsers();
	
}
