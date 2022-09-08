package com.codemobiles.stock_java_backend;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;

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

}
