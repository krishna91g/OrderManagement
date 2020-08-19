package com.order.service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.entity.Orders;
import com.order.jpa.OrderRepository;

@Service
public class OrderService {

	@Autowired
	OrderRepository orderRepository;
	
	
	public List<Orders> retrieveAllOrders() {
		return (List<Orders>) orderRepository.findAll();
	}
	public Orders retrieveOrderByCode(Long Id) {
		List<Orders> ordersList = (List<Orders>) orderRepository.findAll();
		for (Orders order : ordersList) {
			if (order.getOrderId().equals(Id)) {
				return order;
			}
		}
		return null;
	}
	public Orders saveOrders(Orders order) {
		Orders ordr = orderRepository.save(order);
		return ordr;
		
	}
  }

