package com.codemobiles.stock_java_backend;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.codemobiles.stock_java_backend.util.DateUtils;

//@SpringBootApplication
@EnableAutoConfiguration
//scan component is register in project
@ComponentScan
public class StockJavaBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockJavaBackendApplication.class, args);
	}
	
	//injection ApplicationContext ctx into function init()
	@Bean
	CommandLineRunner init(ApplicationContext ctx, DateUtils dateUtils) {
		
		DateUtils obj1 = ctx.getBean(DateUtils.class);
		DateUtils obj2 = ctx.getBean(DateUtils.class);
		
		ctx.getAutowireCapableBeanFactory().destroyBean(obj1);
		ctx.getAutowireCapableBeanFactory().destroyBean(obj2);
		
		return args -> {
//			String[] beanNames = ctx.getBeanDefinitionNames();
//			Arrays.sort(beanNames);
//			for(String beanName : beanNames) {
//				System.out.println(beanName);
//			}
//			System.out.println(dateUtils.todayString());
		};
	}

}
