package com.onlineflowershop.dao;

import java.sql.ResultSet;
import java.util.List;

import com.onlineflowershop.model.Product;

public interface ProductDAO {
	
	public List<Product> viewProduct();
	public void insertProduct(Product product);
	public  void updateProduct(String flowerName,int flowerId);
	public  void insertRating(int insertRating);
	public  void deleteProduct(int flowerId);
	public  int findProductId1(String productName);
	public  ResultSet findPrice(int productId);
	public ResultSet findCategory(String categoryName);


}
