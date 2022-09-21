package com.codemobiles.stock_java_backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

	//request -> path -> process -> response
	@GetMapping("/getProducts")
	public String getProducts() {
		return "Get Product All";
	}
	
	@GetMapping("/getProduct/{id}")
	public String getProduct(@PathVariable long id) {
		return "Get Product By ID : " + id;
	}
}
