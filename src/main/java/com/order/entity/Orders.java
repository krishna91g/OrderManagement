package com.order.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Orders {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
	
	private String customerName;
	private Date orderDate;
	private String address;
	private double totalAmount;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "ordr_col", referencedColumnName = "Id")
	List<Products> products = new ArrayList<>();
	
	public Orders() {
		
	}
	
	public Long getOrderId() {
		return Id;
	}
	public void setOrderId(Long orderId) {
		this.Id = orderId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	public List<Products> getProducts() {
		return products;
	}
	public void setProducts(List<Products> products) {
		this.products = products;
	}
	@Override
	public String toString() {
		return "Order [customerName=" + customerName + ", orderDate=" + orderDate + ", address=" + address
				+ ", totalAmount=" + totalAmount + " ]";
	}
	public Orders(String customerName, Date orderDate, String address, double totalAmount, List<Products> prd) {
		super();
		this.customerName = customerName;
		this.orderDate = orderDate;
		this.address = address;
		this.totalAmount = totalAmount;
		this.products  = prd;
		
	}
	
}
