package com.codemobiles.stock_java_backend.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//use @Component register DateUtils into spring project
//@Component
//@Scope("prototype")
public class DateUtils {
	
	private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
	
	public DateUtils() {
		System.out.println("object created");
	}
	
	@Bean
	public String todayString() {
		return simpleDateFormat.format(new Date());
	}
	
	@PostConstruct
	public void init() throws Exception{
		System.out.println("object init");
	}
	
	@PostConstruct
	public void destroy() throws Exception{
		System.out.println("object destroy");
	}

}
