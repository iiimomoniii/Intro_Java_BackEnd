package com.codemobiles.stock_java_backend.controller.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

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
	
	//ถ้าค่าที่ส่งเข้ามาเป็นnull มันจะเเจ้งว่าค่าไหนเป็น null เช่น name: is Empty ถ้าไม่ส่งค่า name มา
	@NotEmpty(message = "is Empty")
	//กรอกขั้นต่ำ 2 ตัวมากสุด 100 ตัวอักษร
	@Size(min = 2, max =100)
	private String name;
	private MultipartFile image;
	private int price;
	private int stock;

}