package com.demo.phonebookapp.exceptions;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.demo.phonebookapp.payloads.ApiResponse;

@RestControllerAdvice
public class GolbalExceptionHandler {
	
	@ExceptionHandler(value = NoSuchElementException.class)
	public ResponseEntity<ApiResponse> handleNoSuchElementException(NoSuchElementException e){
		String message=e.getMessage();
		ApiResponse apiResponse = new ApiResponse(message, false,LocalDateTime.now());
		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.NOT_FOUND);
		
	}
	

}
