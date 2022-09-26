package com.codemobiles.stock_java_backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

	//request -> path -> process -> response
	//POST MAN : http://localhost:1150/getProducts
	@GetMapping("")
	public String getProducts() {
		return "Get Product All";
	}
	
	//POST MAN : http://localhost:1150/getProduct/1
	@GetMapping("/{id}")
	public String getProductById(@PathVariable long id) {
		return "Get Product By ID : " + id;
	}
	
	
	//POST MAN : http://localhost:1150/getProduct/id/1/name/test
//	@GetMapping("/id/{id}/name/{name}")
//	public String getProductByIdAndName(@PathVariable long id,  @PathVariable String name) {
//		return "Get Product By ID : " + id + " Name : " + name;
//	}
	
	//POST MAN : http://localhost:1150/getProduct/id/1
	@GetMapping({"/id/{id}/name/{name}","/getProduct/id/{id}"})
	public String getProductByIdAndName(@PathVariable(value="id") long id,  @PathVariable(required = false) String name) {
		return "Get Product By ID : " + id + " Name : " + name;
	}
	
//	//POST MAN : http://localhost:1150/getProduct/name?name=natdanai
//	@GetMapping({"/getProduct/name"})
//	public String getProductByNameQuery(@RequestParam("name") String name) {
//		return "Get Product By Name : " + name;
//	}
	
	//POST MAN : http://localhost:1150/getProduct/name?name
	@GetMapping({"/name"})
	public String getProductByNameQuery(@RequestParam(name = "name", required = false, defaultValue = "cat") String name) {
		return "Get Product By Name : " + name;
	}
}
