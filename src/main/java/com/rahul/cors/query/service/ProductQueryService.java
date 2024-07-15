package com.rahul.cors.query.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import com.rahul.cors.query.dto.ProductEvent;
import com.rahul.cors.query.entity.Product;
import com.rahul.cors.query.repo.ProductRepository;

@Service
public class ProductQueryService {

	
	@Autowired
	private ProductRepository productRepository;
	
	
	public List<Product> getProducts(){
		return productRepository.findAll();
	}
	
	@KafkaListener(topics ="cqrs-product-event-topic" ,groupId= "cqrs-event-group")
	public void processProductEvents(@Payload ProductEvent productEvent) {
		Product product = productEvent.getProduct();
		if(productEvent.getEventtype().contentEquals("CreateProduct")) {
			productRepository.save(product); 
		}
		if(productEvent.getEventtype().contentEquals("UpdateProduct")) {
			Product existingProduct = productRepository.findById(product.getId()).get();
			
			existingProduct.setDescription(product.getDescription());
			existingProduct.setName(product.getName());
			existingProduct.setPrice(product.getPrice());
			productRepository.save(existingProduct); 
		}
		
	}
	
	
	
	
}
