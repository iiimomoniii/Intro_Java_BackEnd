package com.codemobiles.stock_java_backend.controller.request;

import org.springframework.web.multipart.MultipartFile;

import com.codemobiles.stock_java_backend.model.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductRequest {
	private String name;
	private MultipartFile image;
	private int price;
	private int stock;

}