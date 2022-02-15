package com.onlineflowershop.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class Cart {

	private int cartId;
	private int productId;
	private String flowerName;
	private int userId;
	private String userName;
	private String emailId;
	private int orderQuantity;
	private double totalPrice;
	private LocalDate orderDate;

	public Cart() {
		super();

	}

	public Cart(int cartId, int productId, String flowerName, int userId, String userName, String emailId,
			int orderQuantity, double totalPrice, LocalDate orderDate) {
		super();
		this.cartId = cartId;
		this.productId = productId;
		this.flowerName = flowerName;
		this.userId = userId;
		this.userName = userName;
		this.emailId = emailId;
		this.orderQuantity = orderQuantity;
		this.totalPrice = totalPrice;
		this.orderDate = orderDate;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getFlowerName() {
		return flowerName;
	}

	public void setFlowerName(String flowerName) {
		this.flowerName = flowerName;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
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

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate date) {
		this.orderDate = date;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cartId, emailId, flowerName, orderDate, orderQuantity, productId, totalPrice, userId,
				userName);
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
		return cartId == other.cartId && Objects.equals(emailId, other.emailId)
				&& Objects.equals(flowerName, other.flowerName) && Objects.equals(orderDate, other.orderDate)
				&& orderQuantity == other.orderQuantity && productId == other.productId
				&& Double.doubleToLongBits(totalPrice) == Double.doubleToLongBits(other.totalPrice)
				&& userId == other.userId && Objects.equals(userName, other.userName);
	}

}