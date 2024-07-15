package com.rahul.cors.query.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name ="PRODUCT_QRY")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	@Id
	@GeneratedValue
	private long id;
	private String name;
	private String description;
	private double price;
}

