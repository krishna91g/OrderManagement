package com.order.jpa;

import org.springframework.data.repository.CrudRepository;

import com.order.entity.Products;

public interface ProductRepository extends CrudRepository<Products, Long>{
  public Products findByProductCode(String productCode);
}
