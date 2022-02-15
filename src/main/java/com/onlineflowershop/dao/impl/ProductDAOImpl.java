package com.onlineflowershop.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import com.onlineflowershop.dao.ProductDAO;
import com.onlineflowershop.model.Product;
import com.onlineflowershop.util.ConnectionUtil;

public class ProductDAOImpl implements ProductDAO {

	// show product method

	@Override
	public List<Product> viewProduct() throws SQLException {
		List<Product> inventorylist = new ArrayList<>();

		String showQurey = "select flower_id,flower_name,flower_description,color,retail_price,category_name,rating,picture from inventory";
		Connection con = null;
		PreparedStatement stmt = null;

		try {
			con = ConnectionUtil.getDbConnection();
			stmt = con.prepareStatement(showQurey);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {

				Product flower = new Product();
				flower.setFlowerId(rs.getInt(1));
				flower.setFlowerName(rs.getString(2));
				flower.setFlowerDescription(rs.getString(3));
				flower.setColor(rs.getString(4));
				flower.setRetailPrice(rs.getDouble(5));
				flower.setCatName(rs.getString(6));
				flower.setRating(rs.getDouble(7));
				flower.setPicture(rs.getString(8));

				inventorylist.add(flower);

			}

		} catch (SQLException e) {

			e.getMessage();
		} finally {
			if (con != null) {
				con.close();
			}
			if (stmt != null) {
				stmt.close();
			}
		}

		return inventorylist;

	}

	// add new product

	@Override
	public void insertProduct(Product product) throws SQLException {
		String insertQuery = "insert into inventory(flower_name,flower_description,color,retail_price,category_name) values(?,?,?,?,?)";

		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = ConnectionUtil.getDbConnection();
			pst = con.prepareStatement(insertQuery);
			pst.setString(1, product.getFlowerName());
			pst.setString(2, product.getFlowerDescription());
			pst.setString(3, product.getColor());
			pst.setDouble(4, product.getRetailPrice());
			pst.setString(5, product.getCatName());
			pst.executeUpdate();

		} catch (SQLException e) {

			e.getMessage();

		} finally {
			if (pst != null) {
				pst.close();
			}
			if (con != null) {
				con.close();
			}
		}

	}

	// update product
	@Override
	public void updateProduct(String flowerName, int flowerId) throws SQLException {
		String updateQuery = "update inventory set flower_name =?  where flower_id=?";
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionUtil.getDbConnection();
			pstmt = con.prepareStatement(updateQuery);
			pstmt.setString(1, flowerName);
			pstmt.setInt(2, flowerId);
			pstmt.executeUpdate();

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

	}


	@Override
	public void insertRating(int insertRating) throws SQLException {

		String updateQuery = "update inventory set Ratings=? where flower_name=?";

		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionUtil.getDbConnection();
			pstmt = con.prepareStatement(updateQuery);
			pstmt.executeUpdate();

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

	}

	// delete method

	@Override
	public void deleteProduct(int flowerId) throws SQLException {
		String deleteQuery = "delete from inventory where flower_id=?";

		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionUtil.getDbConnection();
			pstmt = con.prepareStatement(deleteQuery);
			pstmt.setInt(1, flowerId);
			pstmt.executeUpdate();

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
	}

	// find product id

	@Override
	public int findProductId1(String productName) throws SQLException {
		String selectquery = "select flower_id from inventory where flower_name=?";

		Connection con = null;
		PreparedStatement stmt = null;
		int proId = 0;
		ResultSet rs = null;
		

		try {
			con = ConnectionUtil.getDbConnection();
			stmt = con.prepareStatement(selectquery);
			stmt.setString(1, productName);
            stmt.executeUpdate();
			if (rs.next()) {
				proId = rs.getInt(1);
			}

		} catch (SQLException e) {

			e.getMessage();
		} finally {
			if (stmt != null) {
				stmt.close();
			}
			if (con != null) {
				con.close();
			}
		}

		return proId;

	}

	@Override
	public int findPrice(int productId) throws SQLException {
		String pricequery = "select retail_price from inventory where flower_id=?";

		Connection con = null;
		PreparedStatement stmt = null;
		

		try {
			con = ConnectionUtil.getDbConnection();
			stmt = con.prepareStatement(pricequery);
			stmt.setInt(1, productId);
            ResultSet rs=stmt.executeQuery();
		} catch (SQLException e) {
			e.getMessage();
		} finally {

			if (stmt != null) {
				stmt.close();
			}
			if (con != null) {
				con.close();
			}
		}

		return 0;

	}

	@Override
	public List<Product> findCategory(String categoryName) throws SQLException {
		List<Product> category = new ArrayList<>();

		String showQuery = "select flower_id,flowr_name,flower_description,color,retail_price,category_name,rating from inventory where category_name=?";
				
		Connection con = null;
		PreparedStatement stmt = null;

		try {
			con = ConnectionUtil.getDbConnection();
			stmt = con.prepareStatement(showQuery);
			stmt.executeQuery();

		} catch (SQLException e) {

			e.getMessage();
		} finally {
			if (stmt != null) {
				stmt.close();
			}
			if (con != null)
				con.close();
		}

		return category;
	}

	// show rating

	public List<Product> showRating() throws SQLException {
		List<Product> rating = new ArrayList<>();

		String showquery = "select flower_name,rating from inventory order by rating desc";

		Connection con = null;
		ResultSet rs = null;
		PreparedStatement stmt = null;
		try {
			con = ConnectionUtil.getDbConnection();
			stmt = con.prepareStatement(showquery);
			rs = stmt.executeQuery();

			while (rs.next()) {
				Product flower = new Product();
				flower.setFlowerName(rs.getString(1));

				double ratingAverage = rs.getDouble(2);
				NumberFormat formatter = new DecimalFormat("#0.00");
				ratingAverage = Double.parseDouble(formatter.format(ratingAverage));

				flower.setRating(ratingAverage);

				rating.add(flower);

			}
		} catch (SQLException e) {

			e.getMessage();
		} finally {
			if (stmt != null) {
				stmt.close();
			}
			if (con != null)
				con.close();
		}

		return rating;

	}

	// Category List
	public List<Product> showCategory() throws SQLException {
		List<Product> category = new ArrayList<>();

		String showcategory = "select distinct category_name from inventory";

		Connection con = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionUtil.getDbConnection();
			pstmt = con.prepareStatement(showcategory);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Product flower = new Product();

				flower.setCatName(rs.getString(1));

				category.add(flower);
			}

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

		return category;

	}

//	

	public List<Product> showCategoryList(String categoryname) throws SQLException {
		List<Product> viewCategory = new ArrayList<>();

		String categorylist = "select flower_id,flower_name,flower_description,color,retail_price,category_name,rating,picture from inventory where category_name=?";

		Connection con = null;
		PreparedStatement pstmt = null;

		ResultSet rs = null;
		try {
			con = ConnectionUtil.getDbConnection();
			pstmt = con.prepareStatement(categorylist);
			pstmt.setString(1, categoryname);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Product flower = new Product();
				flower.setFlowerId(rs.getInt(1));
				flower.setFlowerName(rs.getString(2));
				flower.setFlowerDescription(rs.getString(3));
				flower.setColor(rs.getString(4));
				flower.setRetailPrice(rs.getDouble(5));
				flower.setCatName(rs.getString(6));
				flower.setRating(rs.getDouble(7));
				flower.setPicture(rs.getString(8));

				viewCategory.add(flower);
			}

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

		return viewCategory;

	}

}