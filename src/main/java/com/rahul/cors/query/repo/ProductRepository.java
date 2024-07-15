package com.rahul.cors.query.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rahul.cors.query.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
