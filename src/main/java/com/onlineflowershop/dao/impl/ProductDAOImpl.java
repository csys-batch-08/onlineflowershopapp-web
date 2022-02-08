package com.onlineflowershop.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.onlineflowershop.dao.ProductDAO;
import com.onlineflowershop.model.Product;
import com.onlineflowershop.util.ConnectionUtil;

public class ProductDAOImpl implements ProductDAO {

	ConnectionUtil conutil = new ConnectionUtil();
	Connection con = conutil.getDbConnection();

	
	//show product method
	
	public List<Product> viewProduct(){
		List<Product> inventorylist=new ArrayList<Product>();
	
		String showQurey="select flower_id,flower_name,flower_description,color,retail_price,category_name,rating,picture from inventory";
		Connection connection =ConnectionUtil.getDbConnection();
		
		try {
			Statement stmt =connection.createStatement();
			ResultSet rs =stmt.executeQuery(showQurey);
			while(rs.next()) {
				
				Product flower =new Product();
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
			
		}catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return inventorylist;
		
	}
	

		

	//add new product
		
		public void insertProduct(Product product) {
			String insertQuery = "insert into inventory(flower_name,flower_description,color,retail_price,category_name) values(?,?,?,?,?)";

			ConnectionUtil connectionUtil = new ConnectionUtil();
			Connection connection = connectionUtil.getDbConnection();
			PreparedStatement pst = null;

			try {
				pst = con.prepareStatement(insertQuery);
				pst.setString(1, product.getFlowerName());
				pst.setString(2, product.getFlowerDescription());
				pst.setString(3, product.getColor());
				pst.setDouble(4, product.getRetailPrice());
				pst.setString(5,product.getCatName());
				pst.executeUpdate();
				System.out.println("Value inserted Successfully");
			} catch (SQLException e) {
				
				e.printStackTrace();
				System.err.println("Value not inserted in the table");
			}

		}
		
		
		
	//update product
		public  void updateProduct(String flowerName,int flowerId) {
			String updateQuery = "update inventory set flower_name =?  where flower_id=?";
            
			try {
			Connection connection = ConnectionUtil.getDbConnection();
			PreparedStatement pstmt = con.prepareStatement(updateQuery);
			pstmt.setString(1, flowerName);
			pstmt.setInt(2, flowerId);
			int i = pstmt.executeUpdate();
			System.out.println(i + "row updated");
			pstmt.close();
			con.close();
			}catch(SQLException e) {
				System.out.println("incorrect");
				e.printStackTrace();
			}
			
		}
		
	//rating insert 
		public  void insertRating(int insertRating) {
			
			String updateQuery="update inventory set Ratings=? where flower_name=?";
			
			Connection connection=ConnectionUtil.getDbConnection();
			try {
				PreparedStatement pstmt=connection.prepareStatement(updateQuery);
//				pstmt.setInt(1, Integer.parseInt(insertRating.split(",")[1]));
//				pstmt.setString(2, Products.getCakeName());
				pstmt.executeUpdate();
				System.out.println("Rating  added thank you!!");
				pstmt.close();
				con.close();
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
				
			
		}	

	//delete method
		
		public  void deleteProduct(int flowerId)  {
			String deleteQuery = "delete from inventory where flower_id=?";

			Connection con = ConnectionUtil.getDbConnection();
			try {
			PreparedStatement pstmt = con.prepareStatement(deleteQuery);
			pstmt.setInt(1, flowerId);
			int i = pstmt.executeUpdate();
			System.out.println(i + "row deleted");
			pstmt.close();
			con.close();
		}catch (SQLException e) {
			
			e.printStackTrace();
		}
		}
		
		
	//find product id	
		
		public  int findProductId1(String productName)
		{
			String query="select flower_id from inventory where flower_name='"+productName+"'";
			
			Connection connection=ConnectionUtil.getDbConnection();
		    Statement stmt; 
		    int proId=0;
			
			try {
				stmt=con.createStatement();
				
				  ResultSet rs=stmt.executeQuery(query);
				 if(rs.next())
					{
						proId=rs.getInt(1);
					}
				
				
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}	
			
			
			return proId;
			
		}
		

		public  ResultSet findPrice(int productId)
		{
			String query="select * from inventory where flower_id='"+productId+"'";
			
			Connection connetion=ConnectionUtil.getDbConnection();
			Statement stmt;
			ResultSet rs=null;
			
			
			
			try {
				stmt=con.createStatement();
				
				 rs=stmt.executeQuery(query);

				 return rs;
			
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}		
			
			return rs;
			
		}
		
		public ResultSet findCategory(String categoryName) {
			
	 
			Product category=null;
			String showQuery = "select * from inventory where category_name='"+categoryName+"'";
			Connection connection = ConnectionUtil.getDbConnection();
			ResultSet rs=null;
			try {
				Statement stmt = connection.createStatement();
				 rs = stmt.executeQuery(showQuery);
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}

			return rs;
		}
		
		//show rating
		
		public ResultSet ShowRating() {
			
			String query="select flower_name,rating from inventory order by rating desc";
			
			Connection connection=ConnectionUtil.getDbConnection();
			ResultSet rs=null;
			Statement stmt;
			try {
				stmt=con.createStatement();
				rs=stmt.executeQuery(query);
			}catch (SQLException e) {
				
				e.printStackTrace();
			}	
			
			return rs;
			
		}
		
		
		//Category List
	public ResultSet ShowCategory() {
			
			String query="select distinct category_name from inventory";
			System.out.println("hello");
			Connection con=ConnectionUtil.getDbConnection();
			ResultSet rs=null;
			Statement stmt;
			try {
				stmt=con.createStatement();
				rs=stmt.executeQuery(query);
				System.out.println(rs.getString(6));
			}catch (SQLException e) {
				
				e.printStackTrace();
			}	
			
			return rs;
			
		}

//	
	
	
	public ResultSet showCategoryList(String categoryname) {
		String query = "select * from inventory where category_name=?";

		Connection connection = ConnectionUtil.getDbConnection();
		PreparedStatement stmt;

		ResultSet rs = null;
		try {

			stmt = connection.prepareStatement(query);
			stmt.setString(1, categoryname);
			rs = stmt.executeQuery();
			return rs;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		return rs;

	}

		
		
		

		
	}