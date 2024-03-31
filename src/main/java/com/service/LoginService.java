package com.service;

import com.entity.User;
import com.exception.UserNotFoundException;

public interface LoginService {
	
	public User verifyCredentials(String username, String password) throws UserNotFoundException;
	
}
