package com.codemobiles.stock_java_backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codemobiles.stock_java_backend.util.DateUtils;

@RestController
public class DemoController {

	DateUtils dateUtils;
	
	DemoController(DateUtils dateUtils){
		this.dateUtils = dateUtils;
	}
	
	@GetMapping("/")
	String getToday() {
		//เอา @Autowired ออกเพราะตอนทำ unit test เพราะ constructor มัน force ให้ส่งตัวเเปรเข้ามา ตอน new object ขึินมาใหม่มัน require parameter เพื่อให้เราไม่ลืม mock data เพื่อตรวจสอบ
		DemoController demo = new DemoController(null);
		return dateUtils.todayString();
	}
	
}
