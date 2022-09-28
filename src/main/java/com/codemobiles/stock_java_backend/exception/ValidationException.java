package com.codemobiles.stock_java_backend.exception;

public class ValidationException extends RuntimeException{

	public ValidationException(String message) {
		super(message);
	}
}
