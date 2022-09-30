package com.codemobiles.stock_java_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codemobiles.stock_java_backend.model.Product;

//extends เพื่อสืบทอด class JpaRepository (เอาคุณสมบัติ JpaRepository มาใช้ที่ ProductRepository) เเล้วส่ง class ที่จะไป mapping กับ database เเละ ส่ง PK เจ้าไปด้วย
public interface ProductRepository extends JpaRepository<Product, Long>{
	
	

}
