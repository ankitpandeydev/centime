package com.ap.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestControllerAdvice
public class ExceptionHandleController {

	@ExceptionHandler(CustomException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<CustomErrorResponse> handleGenericNotFoundException(CustomException e) {

		CustomErrorResponse error = new CustomErrorResponse("NOT_FOUND_ERROR", e.getMessage());
		error.setTimestamp(LocalDateTime.now());
		error.setStatus((HttpStatus.NOT_FOUND.value()));
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

}
