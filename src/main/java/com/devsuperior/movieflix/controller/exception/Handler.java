package com.devsuperior.movieflix.controller.exception;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

@RestControllerAdvice
public class Handler {
	
	@ExceptionHandler(ResponseStatusException.class)
	public ResponseEntity<String> handler(ResponseStatusException e) {
		return ResponseEntity.status(e.getStatus()).body(e.getReason());
	}
	
	@ExceptionHandler(UnauthorizedException.class)
	public ResponseEntity<OauthCustomError> unauthourized(UnauthorizedException e) {
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new OauthCustomError("unauthourized", e.getMessage()));
	}
	
	@ExceptionHandler(ForbiddenException.class)
	public ResponseEntity<OauthCustomError> forbidden(ForbiddenException e) {
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new OauthCustomError("Forbidden", e.getMessage()));
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<List<ValidationErrorResponse>> handler(MethodArgumentNotValidException e) {
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(validationErrorBody(e));
	}
	
	private List<ValidationErrorResponse> validationErrorBody(MethodArgumentNotValidException e) {
		return e.getBindingResult().getFieldErrors()
				.stream().map(error -> new ValidationErrorResponse(error.getField(), error.getDefaultMessage()))
				.collect(Collectors.toList());
	}
}
