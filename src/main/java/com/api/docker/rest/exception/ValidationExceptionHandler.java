package com.api.docker.rest.exception;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ValidationExceptionHandler {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> notValidRequest(MethodArgumentNotValidException ex, HttpServletRequest request){
		List<String> errors = new ArrayList<>();	
		
		ex.getAllErrors().forEach(err -> errors.add(err.getDefaultMessage()));
		
		Map<String, List<String>> result = new HashMap<>();
		result.put("errors", errors);
		return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
	}
	
    

}
