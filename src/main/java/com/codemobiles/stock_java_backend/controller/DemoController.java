package com.codemobiles.stock_java_backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codemobiles.stock_java_backend.util.DateUtils;

@RestController
public class DemoController {

	@GetMapping("/")
	String getToday(DateUtils dateUtils) {
		return dateUtils.todayString();
	}
	
}
