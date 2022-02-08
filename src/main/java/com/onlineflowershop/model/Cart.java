package com.onlineflowershop.model;

import java.util.Date;
import java.util.Objects;

public class Cart {
	
	private int productId;
	private int userId;
	private int orderQuantity;
	private double totalPrice;
	private Date orderDate;
	
		
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cart(int productId, int userId, int orderQuantity, double totalPrice) {
		super();
		this.productId = productId;
		this.userId = userId;
		this.orderQuantity = orderQuantity;
		this.totalPrice = totalPrice;
		this.orderDate = orderDate;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getOrderQuantity() {
		return orderQuantity;
	}
	public void setOrderQuantity(int orderQuantity) {
		this.orderQuantity = orderQuantity;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	@Override
	public int hashCode() {
		return Objects.hash(orderDate, orderQuantity, productId, totalPrice, userId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cart other = (Cart) obj;
		return Objects.equals(orderDate, other.orderDate) && orderQuantity == other.orderQuantity
				&& productId == other.productId
				&& Double.doubleToLongBits(totalPrice) == Double.doubleToLongBits(other.totalPrice)
				&& userId == other.userId;
	}
	@Override
	public String toString() {
		return "Cart [productId=" + productId + ", userId=" + userId + ", orderQuantity=" + orderQuantity
				+ ", totalPrice=" + totalPrice + ", orderDate=" + orderDate + "]";
	}
	
	
	
	
	
	
	
	

}
