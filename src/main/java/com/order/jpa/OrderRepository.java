package com.order.jpa;

import org.springframework.data.repository.CrudRepository;

import com.order.entity.Orders;

public interface OrderRepository extends CrudRepository<Orders, Long>{

}
