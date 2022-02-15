package com.onlineflowershop.dao;

import java.sql.SQLException;
import java.util.List;

import com.onlineflowershop.model.Cart;

public interface CartDAO {

	public void insertCart(Cart cart) throws SQLException;

	public void updateCart(String updateCart) throws SQLException;

	public int findCartId(int cart) throws SQLException;

	public List<Cart> showUserCart(int userId) throws SQLException;

	public List<Cart> showCart() throws SQLException;

	void deleteCart(int userId) throws SQLException;
}
