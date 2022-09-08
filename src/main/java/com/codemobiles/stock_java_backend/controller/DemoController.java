package com.codemobiles.stock_java_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codemobiles.stock_java_backend.util.DateUtils;

@RestController
public class DemoController {

	@Autowired
	DateUtils dateUtils;
	
	@GetMapping("/")
	String getToday() {
		return dateUtils.todayString();
	}
	
}
