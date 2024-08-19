package com.swipeup.user.service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.swipeup.user.service.payload.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> resourceNotFoundExeptionHandler(ResourceNotFoundException ex) {
		
		String message = ex.getMessage();
		boolean status = false;
		ApiResponse res = new ApiResponse(message,status);
		return new ResponseEntity<ApiResponse>(res,HttpStatus.NOT_FOUND);
		
		
	}

}
