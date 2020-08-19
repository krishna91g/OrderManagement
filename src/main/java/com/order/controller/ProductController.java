package com.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.order.entity.Orders;
import com.order.entity.Products;
import com.order.exception.CustomException;
import com.order.service.ProductService;
import java.util.List;
import javax.validation.Valid;

@RestController
@Validated
public class ProductController {
	
	@Autowired
	private ProductService productService;
	/*
	 * This API is used to retrieve all products
	 * 
	 * */
	@GetMapping("/products")
	public List<Products> retrieveAllProducts()throws Throwable{
		System.out.println("inside alll products");
		List<Products> products = null;
		products = productService.retrieveAllProducts();
		if (products.size()==0) {
			throw new CustomException("No products available");
		} else {
			return products;
		}
	}
	/*
	 * This API is used to retrieve products for the given product code
	 * 
	 * */
	@GetMapping("/products/{productCode}")
	public Products retrieveProductsByCode(@PathVariable String productCode) throws Throwable  {
		System.out.println("Product Name is::: "+productCode );
		Products prd = null;
		System.out.println("prd====="+prd);
		prd =  productService.retrieveProductsByCode(productCode);		
		if (prd == null) {
			throw new CustomException("No products available for the productCode::" + productCode);
		} else {
			return prd;
		}
		
	}
			
	/*
	 * This API is used to create product	 * 
	 * */
	
	@PostMapping(value = "/product")
	public Products saveProducts(@RequestBody @Valid Products product) {
		return productService.saveProduct(product);
		
	}
}
