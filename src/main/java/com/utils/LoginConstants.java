package com.utils;

import org.springframework.stereotype.Component;

@Component
public class LoginConstants {
	private LoginConstants() {}
	
	public static final String SESSION_LOGGEDIN = "LOGGEDIN";
	public static final String SESSION_LOGGEDOUT = "LOGGEDOUT";
	public static final String SESSION_EXPIRED = "EXPIRED";
}
