package com.kpit.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.kpit.dto.Response;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = AccountAlreadyExistException.class)
	public ResponseEntity<Object> handleAccountAlreadyExistException(AccountAlreadyExistException accountAlreadyExistException){
		Response response = new Response(accountAlreadyExistException.getMessage());
		return new ResponseEntity<Object>(response,HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(value = AccountNotFoundException.class)
	public ResponseEntity<Object> handleAccountNotFoundException(AccountNotFoundException accountNotFoundException){
		Response response = new Response(accountNotFoundException.getMessage());
		return new ResponseEntity<Object>(response,HttpStatus.NOT_FOUND);
	}
}
