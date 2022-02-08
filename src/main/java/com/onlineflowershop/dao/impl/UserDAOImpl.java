package com.onlineflowershop.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.onlineflowershop.dao.UserDAO;
import com.onlineflowershop.model.User;
import com.onlineflowershop.util.ConnectionUtil;

public class UserDAOImpl implements UserDAO {

	public void insertUser(User user) {
		String insertQuery = "insert into User_Details(name,email_id,Password,address,mobile_number) values(?,?,?,?,?)";

		Connection con = ConnectionUtil.getDbConnection();
		PreparedStatement pst = null;

		try {
			pst = con.prepareStatement(insertQuery);

			pst.setString(1, user.getName());
			pst.setString(2, user.getEmailId());
			pst.setString(3, user.getPassword());
			pst.setString(4, user.getAddress());
			pst.setLong(5, user.getMobileNumber());
			pst.executeUpdate();
			System.err.println("Value inserted Success");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Value not inserted in the table");
		}

	}

//validate user method	

	public User validateUser(String emailId, String password) {
		String validateQuery = "select * from user_details where email_id='" + emailId + "'and password='" + password
				+ "'";

		Connection con = ConnectionUtil.getDbConnection();
		User user = null;
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(validateQuery);
			if (rs.next()) {
				user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getLong(6), rs.getString(7), rs.getDouble(8));
						
						return user;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("Statement error");
		}
		return user;
	}

	// show all user method
       public List<User> showUser(){
    	   
    	   List<User> userlist=new ArrayList<User>();
    	   
    	   String showQuery="select user_id,name,email_id,password,address,mobile_number,role,walllet";
    	   Connection con=ConnectionUtil.getDbConnection();
    	   try {
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(showQuery);
			while(rs.next()) {
				User user=new User();
				user.setUserId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setEmailId(rs.getString(3));
				user.setPassword(rs.getString(4));
				user.setAddress(rs.getString(5));
				user.setMobileNumber(rs.getLong(6));
				user.setRole(rs.getString(7));
				user.setWallet(rs.getDouble(8));
				
				userlist.add(user);
				
				
				
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    	   return userlist;
       }
	
	
	// update user
	public void update(String update) {
		String updateQuery = "update user_details set password=?  where email_id=?";

		Connection con = ConnectionUtil.getDbConnection();

		try {
			PreparedStatement pstmt = con.prepareStatement(updateQuery);
			pstmt.setString(1, update.split(",")[0]);
			pstmt.setString(2, update.split(",")[1]);
			int i = pstmt.executeUpdate();
			System.out.println(i + "row updated");
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// delete method

	public void deletedetails(String delete) {
		String deleteQuery = "delete from user_details where email_id=?";

		Connection con = ConnectionUtil.getDbConnection();
		try {
			PreparedStatement pstmt = con.prepareStatement(deleteQuery);
			pstmt.setString(1, delete);
			int i = pstmt.executeUpdate();
			System.out.println(i + "row deleted");
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// find user id method

	public int findUserId(String Name) {

		String findUserID = "select user_id from user_details where name='" + Name + "'";
		Connection con = ConnectionUtil.getDbConnection();
		Statement stmt;

		int userId = 0;
		try {
			stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery(findUserID);

			if (rs.next()) {
				userId = rs.getInt(1);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userId;

	}

//get wallet balance:
	public ResultSet walletbal(int id) {
		ResultSet rs = null;
		try {
			Connection con = ConnectionUtil.getDbConnection();
			System.out.println(id);
			String query = "select user_wallet from user_details where user_id = ?";
			PreparedStatement statement = con.prepareStatement(query);
			statement.setInt(1, id);
			rs = statement.executeQuery();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	// update wallet balance:
	public int updatewallet(int amount, int userid) {

		Connection con = ConnectionUtil.getDbConnection();
		int res = 0;
		try {
			String query = "update user_details set user_wallet = ? where user_id = ?";
			PreparedStatement statement = con.prepareStatement(query);
			statement.setInt(1, amount);
			statement.setInt(2, userid);
			// statement.executeUpdate("commit");
			res = statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		return res;

	}

}
