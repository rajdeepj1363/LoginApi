package com.exception;

import java.time.LocalDateTime;

public class ExceptionTemplate {
	
	private LocalDateTime dateTime;
	private String exceptionMessage;
	private int statusCode;
	
	public ExceptionTemplate()
	{
		
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public String getExceptionMessage() {
		return exceptionMessage;
	}

	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	
	
}
