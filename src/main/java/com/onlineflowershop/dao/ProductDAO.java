package com.onlineflowershop.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.onlineflowershop.model.Product;

public interface ProductDAO {
	
	public List<Product> viewProduct() throws SQLException;
	public void insertProduct(Product product) throws SQLException;
	public  void updateProduct(String flowerName,int flowerId) throws SQLException;
	public  void insertRating(int insertRating) throws SQLException;
	public  void deleteProduct(int flowerId) throws SQLException;
	public  int findProductId1(String productName) throws SQLException;
	public  int findPrice(int productId) throws SQLException;
	public List<Product> findCategory(String categoryName) throws SQLException;


}
