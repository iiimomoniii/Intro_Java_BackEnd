package com.codemobiles.stock_java_backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProductController {

	//request -> path -> process -> response
	@RequestMapping("/say")
	@ResponseBody
	public String say() {
		return "Hi";
	}
}
