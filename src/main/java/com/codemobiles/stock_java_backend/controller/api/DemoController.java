package com.codemobiles.stock_java_backend.controller.api;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codemobiles.stock_java_backend.util.DateUtils;

//@RestController
public class DemoController {

	DateUtils dateUtils;
	private SayService sayService;
	
	//การเเก้ไข multiple bean ใน SayService โดยการเรียก ชื่อ component โดยหลังจากเรียกเเล้วมันก็จะเอาไปลงทะเบียน ใน spring boot ให้
	//เช่น dog 
	//เเต่วิธีนี้เราก็ต้องมาจำชื่อเเต่ละ component
	//เเค่ถ้าเพิ่ม @Qualifier เราอยากเรียกอะไรก็ส่งค่าเข้าไปเลย
	DemoController(DateUtils dateUtils, @Qualifier("cat_sound") SayService sayService){
		this.dateUtils = dateUtils;
		this.sayService = sayService;
	}
	
	@GetMapping("/")
	String getToday() {
		return dateUtils.todayString();
	}
	
	@GetMapping("/say")
	String say() {
		return sayService.say();
	}
	
}

interface SayService {
	String say();
}

//register Cat
@Component("cat_sound")
class Cat implements SayService {
	@Override
	public String say() {
		return "meooow";
	}
}

//register Dog
@Component
class Dog implements SayService {
	@Override
	public String say() {
		return "hoooog";
	}
}