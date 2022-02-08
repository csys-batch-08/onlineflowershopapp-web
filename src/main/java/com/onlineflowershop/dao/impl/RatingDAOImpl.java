package com.onlineflowershop.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.onlineflowershop.dao.RatingDAO;
import com.onlineflowershop.util.ConnectionUtil;

public class RatingDAOImpl implements RatingDAO {
	
	
	public  void updateRating(int rating,int flowerId){
		String updateQuery="update inventory set rating=? where flower_id=?";
	
		Connection con=ConnectionUtil.getDbConnection();
		//System.out.println("Connection successfully");		
		PreparedStatement pstmt=null;
		try {
			pstmt = con.prepareStatement(updateQuery);
			pstmt.setInt(1,rating);
			pstmt.setInt(2, flowerId);			
			pstmt.executeUpdate();
			System.out.println("Rating Updated successfully");
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public  int findRating(String flowerName)
	{
		String findRating="select rating from inventory where flower_name='"+flowerName+"'";
		Connection con=ConnectionUtil.getDbConnection();
		Statement stmt;
		int rating=0;
		try {
			stmt = con.createStatement();
			System.out.println(flowerName);
			ResultSet rs=stmt.executeQuery(findRating);
			if(rs.next())
			{
			rating=rs.getInt(1);
			System.out.println(rating);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rating;
		
	}

}

	


