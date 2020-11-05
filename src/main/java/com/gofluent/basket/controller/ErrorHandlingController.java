package com.gofluent.basket.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gofluent.basket.exception.EntityNotFoundException;

@RestController
public class ErrorHandlingController {
	
	
	@ResponseStatus(value = HttpStatus.OK)
	@ExceptionHandler({EntityNotFoundException.class})
	public ResponseEntity<?> handleBusinessRule(EntityNotFoundException e) {		
		System.out.println(e.getMessage() + "aaaaaaaaaaaaaaaaaaa");
		return ResponseEntity.status(HttpStatus.OK).body(e.getMessage());
	}

}
