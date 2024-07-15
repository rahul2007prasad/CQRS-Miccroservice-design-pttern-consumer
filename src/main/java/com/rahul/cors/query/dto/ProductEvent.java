package com.rahul.cors.query.dto;

import com.rahul.cors.query.entity.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductEvent {

	
	private String eventtype;
	private Product product;
}
