package com.codemobiles.stock_java_backend.exception;

public class ProductNotFoundException extends RuntimeException{
	
	public ProductNotFoundException(Long id) {
		super("Could not found product : " + id);
	}

}
