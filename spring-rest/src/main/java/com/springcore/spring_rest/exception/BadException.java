package com.springcore.spring_rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.BAD_REQUEST)
public class BadException extends RuntimeException{
	public BadException(String message){
		super(message);
	}
	public BadException(String message, Throwable cause){
		super(message, cause);
	}
}
