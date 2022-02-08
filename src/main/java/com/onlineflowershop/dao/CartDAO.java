package com.onlineflowershop.dao;

import java.sql.ResultSet;
import java.util.List;

import com.onlineflowershop.model.Cart;

public interface CartDAO {
	
	public void insertCart(Cart cart);
	public  void updateCart(String updateCart);
	public  void deleteCart(String delete);
	public  int findCartId(int cart);
	public int walletbal (int id);  
	public int updatewallet(int amount,int userid); 
	public ResultSet showUserCart(int userId);
	public  List<Cart> showCart();
}
