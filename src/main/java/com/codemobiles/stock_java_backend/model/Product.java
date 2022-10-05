package com.codemobiles.stock_java_backend.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.AccessLevel;

@Data
@AllArgsConstructor
@Entity
public class Product {
	private @Id  @GeneratedValue(strategy = GenerationType.IDENTITY) long id;
	@Column(length =150, nullable = false, unique = false)
	private String name;
	private String image;
	private int price;
	private int stock;
	
	//เพื่อไม่ให้มีการ new obj.set createDate เองเเต่จะให้ระบบสร้างให้เอง 
	@Setter(AccessLevel.NONE)
	//ให้ระบบสร้าง createDate ขึ้นมาเอง
	@CreationTimestamp
	//ระบุให้วันที่เป็น timestamp
	@Temporal(TemporalType.TIMESTAMP)
	//เปลี่ยนชื่อใหม่
	@Column(name = "create_date", nullable = false)
	private Date createDate;
	
	@Setter(AccessLevel.NONE)
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "update_date", nullable = false)
	private Date updateDate;

}
