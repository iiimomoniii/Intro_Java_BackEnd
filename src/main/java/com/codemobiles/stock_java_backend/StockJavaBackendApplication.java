package com.codemobiles.stock_java_backend;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.codemobiles.stock_java_backend.util.DateUtils;

@SpringBootApplication
public class StockJavaBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockJavaBackendApplication.class, args);
	}

}
