package com.codemobiles.stock_java_backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

	//request -> path -> process -> response
	@RequestMapping("/say")
	public String say() {
		return "Hi";
	}
}
