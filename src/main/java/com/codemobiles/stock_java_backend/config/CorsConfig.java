package com.codemobiles.stock_java_backend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		//ปลดล๊อค /** cors ทั้งหมด
		registry.addMapping("/**");
		//ให้เข้าถึง product เเละใช้เฉพาะ GET POST method เท่านั้น
		registry.addMapping("/product/*").allowedMethods("*");
	}

}
