package com.order.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.entity.Products;
import com.order.jpa.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;
	
	public List<Products> retrieveAllProducts() {
		return (List<Products>) productRepository.findAll();
	}
	public Products retrieveProductsByCode(String productCode) {
		Products productslist =  productRepository.findByProductCode(productCode);
			return productslist;
	}
	public Products saveProduct(Products product) {
		Products prd = productRepository.save(product);
		return prd;
		
	}
  }

