package com.codemobiles.stock_java_backend.exception;

import javax.naming.SizeLimitExceededException;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

@RestControllerAdvice
public class ExceptionAdvice {

	@ExceptionHandler
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String handleProductNotFound(ProductNotFoundException ex) {
		return ex.getMessage();
	}
	
	@ExceptionHandler
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	String handleStorageExceptionNotFound(StorageException ex) {
		return ex.getMessage();
	}
	
	@ExceptionHandler
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	String handleMaxUploadSizeExceptionNotFound(MaxUploadSizeExceededException ex) {
		return "maximum upload size exceeded";
	}
	
	@ExceptionHandler
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	String handleValidationExceptionNotFound(ValidationException ex) {
		return ex.getMessage();
	}

}
