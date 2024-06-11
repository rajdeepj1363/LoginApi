package com.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ExceptionTemplate> handleUserNotFoundException(UserNotFoundException e)
	{
		ExceptionTemplate exception = new ExceptionTemplate();
		exception.setDateTime(LocalDateTime.now());
		exception.setExceptionMessage(e.getMessage());
		exception.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		return new ResponseEntity<ExceptionTemplate>(exception,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(InvalidPasswordException.class)
	public ResponseEntity<ExceptionTemplate> handleInvalidPasswordException(InvalidPasswordException e)
	{
		ExceptionTemplate exception = new ExceptionTemplate();
		exception.setDateTime(LocalDateTime.now());
		exception.setExceptionMessage(e.getMessage());
		exception.setStatusCode(HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<ExceptionTemplate>(exception, HttpStatus.BAD_REQUEST);
	}
	
	
}
