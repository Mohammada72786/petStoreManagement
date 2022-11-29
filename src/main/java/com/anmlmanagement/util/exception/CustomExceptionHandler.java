package com.anmlmanagement.util.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.anmlmanagement.model.Message;


@RestControllerAdvice
public class CustomExceptionHandler {
	
	@ExceptionHandler(AnimalManagementException.class)
	public ResponseEntity<Message> AnimalManagementExceptionhandler(AnimalManagementException exception, WebRequest request) {
		Message message = new Message(HttpStatus.NOT_ACCEPTABLE.value(),
				new Date(), 
				exception.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<Message>(message, HttpStatus.NOT_ACCEPTABLE);
	}
	
	@ExceptionHandler(UsernameNotFoundException.class)
	public ResponseEntity<Message> UsernameNotFoundhandler(UsernameNotFoundException exception, WebRequest request) {
		Message message = new Message(HttpStatus.NOT_FOUND.value(),
				new Date(), 
				exception.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<Message>(message, HttpStatus.NOT_FOUND);
	}
}
