package com.onlineflowershop.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import com.onlineflowershop.dao.CartDAO;
import com.onlineflowershop.model.Cart;
import com.onlineflowershop.util.ConnectionUtil;

public class CartDAOImpl implements CartDAO {

	@Override
	public void insertCart(Cart cart) throws SQLException {
		
		String insertQuery = "insert into cart_items(flower_id,user_id,order_quantity,total_price) values(?,?,?,?)";

		 
		Connection con =null;
		PreparedStatement pst = null;

		try {
			con = ConnectionUtil.getDbConnection();
			
			pst = con.prepareStatement(insertQuery);
			pst.setInt(1, cart.getProductId());
			pst.setInt(2, cart.getUserId());
			pst.setInt(3, cart.getOrderQuantity());
			pst.setDouble(4, cart.getTotalPrice());
			pst.executeUpdate();
			
		} catch (SQLException e) {

			e.getMessage();
			
		}finally {
			if(con !=null) {
				con.close();
			}
			if(pst !=null) {
				pst.close();
			}
				
		}
	}

	// view cart items

	@Override
	public List<Cart> showCart() throws SQLException {
		List<Cart> cartlist = new ArrayList<>();

		String listquery = "select flower_id,count(order_quantity),sum(total_price),user_id,trunc(order_date) from cart_items group by flower_id,user_id ,trunc(order_date)order by trunc(order_date) desc";
		Connection con = null;
		PreparedStatement pst =null;
		ResultSet rs =null;
		

		try {
			con = ConnectionUtil.getDbConnection();
		    pst= con.prepareStatement(listquery);
			rs = pst.executeQuery();
			while (rs.next()) {

				Cart flower = new Cart();
				flower.setProductId(rs.getInt(1));
				flower.setOrderQuantity(rs.getInt(2));
				flower.setTotalPrice(rs.getDouble(3));
				flower.setUserId(rs.getInt(4));
				flower.setOrderDate(rs.getDate(5).toLocalDate());

				cartlist.add(flower);

			}
		} catch (Exception e) {
			e.getMessage();
		}
		finally {
			if(pst !=null) {
				pst.close();
			}
			if(con !=null) {
				con.close();
			}
		}
		return cartlist;
	}

	// update cart
	@Override
	public void updateCart(String updateCart) throws SQLException {
		String updateQuery = "update cart_items set order_quantity =? where cart_id=?";
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionUtil.getDbConnection();
			pstmt = con.prepareStatement(updateQuery);
			pstmt.setInt(1, Integer.parseInt(updateCart.split(",")[0]));
			pstmt.setInt(2, Integer.parseInt(updateCart.split(",")[1]));
		    pstmt.executeUpdate();
			
			
		} catch (SQLException e) {

			e.getMessage();
		}finally {
			if(pstmt !=null) {
				pstmt.close();
			}
			if(con !=null) {
				con.close();
			}
		}
	}

	// delete cart

	@Override
	public void deleteCart(int userId) throws SQLException {
		String deleteQuery = "delete from cart_items where cart_id=?";
		Connection con =null;
		PreparedStatement pstmt =null;
				
		try {
			con = ConnectionUtil.getDbConnection();
			pstmt = con.prepareStatement(deleteQuery);
			pstmt.setInt(1, userId);
		    pstmt.executeUpdate();
			
		} catch (SQLException e) {

			e.getMessage();

		}finally {
			if(pstmt !=null) {
				pstmt.close();
			}
			if(con !=null)
				con.close();
		}
	}

	// find cart id

	@Override
	public int findCartId(int cart) throws SQLException {
		String findcart = "select cart_id from product_details where user_id=?";

		Connection con = ConnectionUtil.getDbConnection();
		PreparedStatement pst =null;
		int cartId = 0;
		try {
			con = ConnectionUtil.getDbConnection();
			pst = con.prepareStatement(findcart);
			pst.setInt(1, cartId);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				cartId = rs.getInt(1);
			}
			

		} catch (SQLException e) {

			e.getMessage();
		}finally {
			if(pst !=null) {
				pst.close();
			}
			if(con !=null) {
				con.close();
			}
		}

		return cartId;

	}

	
		

	@Override
	public List<Cart> showUserCart(int userId) throws SQLException {

		List<Cart> orderlist = new ArrayList<>();
		String userCart = "select cart_id,email_id,flower_name,order_quantity,total_price,order_date from cart_items inner join user_details using (user_id)inner join inventory using(flower_id) where user_id=?";

		Connection con = null;
		PreparedStatement pstmt = null;

		ResultSet rs = null;
		
		try {
			con = ConnectionUtil.getDbConnection();
			pstmt = con.prepareStatement(userCart);
			pstmt.setInt(1, userId);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				Cart cart = new Cart();
				cart.setCartId(rs.getInt(1));
				cart.setEmailId(rs.getString(2));
				cart.setFlowerName(rs.getString(3));
				cart.setOrderQuantity(rs.getInt(4));
				cart.setTotalPrice(rs.getDouble(5));
				cart.setOrderDate(rs.getDate(6).toLocalDate());
				orderlist.add(cart);
				

			}
			return orderlist;
			
		} catch (SQLException e) {

			e.getMessage();
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
			if (con != null) {
				con.close();
			}

		}

		return orderlist;
	
	}

	
}
