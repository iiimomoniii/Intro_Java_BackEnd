package com.codemobiles.stock_java_backend.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

//use @Component register DateUtils into spring project
@Component
public class DateUtils {
	
	private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
	
	public DateUtils() {
		System.out.println("object created");
	}
	
	public String todayString() {
		return simpleDateFormat.format(new Date());
	}

}
