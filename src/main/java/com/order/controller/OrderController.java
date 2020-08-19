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
import com.order.service.OrderService;
import java.util.List;
import javax.validation.Valid;

@RestController
@Validated
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	/**
	 * This API is used to retrieve all orders
	 * 
	 */
	@GetMapping("/orders")
	public List<Orders> retrieveAllProducts() throws Throwable{
		//System.out.println("inside all orders");
		List<Orders> order = null;
		order = orderService.retrieveAllOrders();
		if (order.size()==0) {
			throw new CustomException("No orders available");
		} else {
			return order;
		}
	}
	
	/**
	 * This API is used to retrieve orders for the given Id
	 * 
	 */
	@GetMapping("/orders/{Id}")
	public Orders retrieveProductsByCode(@PathVariable Long Id) throws Throwable  {
		Orders order = null;
		order =  orderService.retrieveOrderByCode(Id);		
		if (order == null) {
			throw new CustomException("No orders available for the Order Id::" + order);
		} else {
			return order;
		}
		
	}
			
	/**
	 * This API is used to save new Order
	 * 
	 */
	@PostMapping(value = "/order")
	public Orders saveOrder(@RequestBody @Valid Orders order) {
		Products prd = new Products("Nokia 1100","Nokia",2);
		order.getProducts().add(prd);
		return orderService.saveOrders(order);
		
	}
}
