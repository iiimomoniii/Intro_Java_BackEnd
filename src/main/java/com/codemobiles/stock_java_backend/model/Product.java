package com.codemobiles.stock_java_backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
public class Product {
	private long id;
	private String name;
	private String image;
	private int price;
	private int stock;

}
