package com.rahul.cors.query.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rahul.cors.query.entity.Product;
import com.rahul.cors.query.service.ProductQueryService;

@RestController
@RequestMapping("/products")
public class ProductQueryController {

	@Autowired
	private ProductQueryService productQueryService;
	
	@GetMapping
	public List<Product> fetchAllProducts(){
		return productQueryService.getProducts();
	}
	
	
	
	
	
}
