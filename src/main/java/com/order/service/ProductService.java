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
		List<Products> productslist = (List<Products>) productRepository.findAll();
		for (Products product : productslist) {
			if (product.getProductCode().equals(productCode)) {
				return product;
			}
		}
		return null;
	}
	public Products saveProduct(Products product) {
		Products prd = productRepository.save(product);
		return prd;
		
	}
  }

