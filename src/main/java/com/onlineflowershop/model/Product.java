package com.onlineflowershop.model;

public class Product {
	
	
	private int flowerId;
	private String flowerName;
	private String flowerDescription;
	private String color;
	private double retailPrice;
	private String catName;
	private double rating;
	private String picture;
	
	
	
	public Product(int flowerId, String flowerName, String flowerDescription, String color, double retailPrice,
			String catName, double rating, String picture) {
		super();
		this.flowerId = flowerId;
		this.flowerName = flowerName;
		this.flowerDescription = flowerDescription;
		this.color = color;
		this.retailPrice = retailPrice;
		this.catName = catName;
		this.rating = rating;
		this.picture = picture;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(int flowerId, String flowerName, String flowerDescription, String color, double retailPrice,
			String catName, double rating) {
		super();
		this.flowerId = flowerId;
		this.flowerName = flowerName;
		this.flowerDescription = flowerDescription;
		this.color = color;
		this.retailPrice = retailPrice;
		this.catName = catName;
		this.rating = rating;
	}
	public int getFlowerId() {
		return flowerId;
	}
	public void setFlowerId(int flowerId) {
		this.flowerId = flowerId;
	}
	public String getFlowerName() {
		return flowerName;
	}
	public void setFlowerName(String flowerName) {
		this.flowerName = flowerName;
	}
	public String getFlowerDescription() {
		return flowerDescription;
	}
	public void setFlowerDescription(String flowerDescription) {
		this.flowerDescription = flowerDescription;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public double getRetailPrice() {
		return retailPrice;
	}
	public void setRetailPrice(double retailPrice) {
		this.retailPrice = retailPrice;
	}
	public String getCatName() {
		return catName;
	}
	public void setCatName(String catName) {
		this.catName = catName;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	@Override
	public String toString() {
		return "Product [flowerId=" + flowerId + ", flowerName=" + flowerName + ", flowerDescription="
				+ flowerDescription + ", color=" + color + ", retailPrice=" + retailPrice + ", catName=" + catName
				+ ", rating=" + rating + ", picture=" + picture + "]";
	}
	
	

}
