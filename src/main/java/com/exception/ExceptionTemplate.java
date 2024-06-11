package com.exception;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExceptionTemplate {
	
	private LocalDateTime dateTime;
	private String exceptionMessage;
	private int statusCode;
	
	public ExceptionTemplate()
	{
		
	}
}
