package com.swipeup.hotel.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.swipeup.hotel.entity.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> ResourceNotFoundExceptionHandler(ResourceNotFoundException ex) {

		String Message = ex.getMessage();
		Boolean status = true;

		ApiResponse api = new ApiResponse(Message, status);

		return new ResponseEntity<ApiResponse>(api, HttpStatus.NOT_FOUND	);

	}

}
