package com.app.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.app.dto.ApiResponse;



@RestControllerAdvice
public class GlobalExceptionHandler{
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleException(Exception e){
		
		return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(new ApiResponse(e.getMessage()));
	}
	
	

}
