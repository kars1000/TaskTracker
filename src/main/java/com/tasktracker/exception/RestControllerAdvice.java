package com.tasktracker.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.persistence.OptimisticLockException;

@org.springframework.web.bind.annotation.RestControllerAdvice
public class RestControllerAdvice {

	@ExceptionHandler(ObjectOptimisticLockingFailureException.class)
	public ResponseEntity<ErrorResponse> handleOptimisticLocking(Exception ex) {
		ErrorResponse error = new ErrorResponse(HttpStatus.CONFLICT.value(), "The record was updated by another user please refresh and try again", ex.getMessage());
		return new ResponseEntity<>(error, HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(OptimisticLockException.class)
	public ResponseEntity<ErrorResponse> handleOptimisticLockingException(Exception ex) {
		ErrorResponse error = new ErrorResponse(HttpStatus.CONFLICT.value(), "The record was updated by another user please refresh and try again", ex.getMessage());
		return new ResponseEntity<>(error, HttpStatus.CONFLICT);
	}

}
