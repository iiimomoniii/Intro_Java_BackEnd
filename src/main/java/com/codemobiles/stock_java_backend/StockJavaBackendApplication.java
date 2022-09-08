package com.codemobiles.stock_java_backend;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

//@SpringBootApplication
@EnableAutoConfiguration
public class StockJavaBackendApplication {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(StockJavaBackendApplication.class, args);
		
		String[] beanNames = ctx.getBeanDefinitionNames();
		Arrays.sort(beanNames);
		for(String beanName : beanNames) {
			System.out.println(beanName);
		}
	}
	
	@Bean
	CommandLineRunner init() {
		//return by lambda function
		return args -> {
			System.out.println("natdanai");
		};
	}

}
