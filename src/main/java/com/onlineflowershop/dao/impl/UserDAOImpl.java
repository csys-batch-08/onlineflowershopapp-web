package com.onlineflowershop.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import com.onlineflowershop.dao.UserDAO;
import com.onlineflowershop.model.User;
import com.onlineflowershop.util.ConnectionUtil;

public class UserDAOImpl implements UserDAO {

	@Override
	public void insertUser(User user) throws SQLException {
		String insertQuery = "insert into User_Details(name,email_id,Password,address,mobile_number) values(?,?,?,?,?)";

		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = ConnectionUtil.getDbConnection();
			pst = con.prepareStatement(insertQuery);

			pst.setString(1, user.getName());
			pst.setString(2, user.getEmailId());
			pst.setString(3, user.getPassword());
			pst.setString(4, user.getAddress());
			pst.setLong(5, user.getMobileNumber());
			pst.executeUpdate();
			
		} catch (SQLException e) {
			
			e.getMessage();
			
		}finally {
			if(pst!=null) {
				pst.close();
			}
			if(con !=null) {
				con.close();
			}
		}

	}

//validate user method	

	@Override
	public User validateUser(String emailId, String password) throws SQLException {
		String validateQuery = "select user_id,name,email_id,password,address,mobile_number,role,walllet from user_details where email_id='" + emailId + "'and password='" + password
				+ "'";
		
		Connection con =null;
		User user=null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;

		try {

		    con= ConnectionUtil.getDbConnection();
			pstmt = con.prepareStatement(validateQuery);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				 user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getLong(6), rs.getString(7), rs.getDouble(8));

				return user;
			}
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
		return user;
	}

	// show all user method
	@Override
	public List<User> showUser() {

		List<User> userlist = new ArrayList<>();

		String showQuery = "select user_id,name,email_id,password,address,mobile_number,role,walllet";
		Connection con = null;
		PreparedStatement stmt=null;
		ResultSet rs =null;
		try {
			con = ConnectionUtil.getDbConnection();
			stmt = con.prepareStatement(showQuery);
			rs = stmt.executeQuery();
			while (rs.next()) {
				User user = new User();
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
			
			e.getMessage();
		}
		return userlist;
	}

	// update user
	@Override
	public void update(String update) throws SQLException {
		String updateQuery = "update user_details set password=?  where email_id=?";

		Connection con = null;
		PreparedStatement pstmt=null;

		try {
			con = ConnectionUtil.getDbConnection();

			pstmt = con.prepareStatement(updateQuery);
			pstmt.setString(1, update);
			pstmt.setString(2, update);
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

	// delete method

	@Override
	public void deletedetails(String delete) throws SQLException {
		String deleteQuery = "delete from user_details where email_id=?";

		Connection con =null;
		PreparedStatement pstmt =null;
		try {
			con = ConnectionUtil.getDbConnection();
		    pstmt = con.prepareStatement(deleteQuery);
			pstmt.setString(1, delete);
		    pstmt.executeUpdate();
			
			pstmt.close();
			con.close();
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

	// find user id method

	@Override
	public int findUserId(String Name) throws SQLException {

		String findUserID = "select user_id from user_details where name='" + Name + "'";
		Connection con = ConnectionUtil.getDbConnection();
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		

		int userId = 0;
		try {
			pstmt = con.prepareStatement(findUserID);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				userId = rs.getInt(1);
			}

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
		return userId;

	}

//get wallet balance:
	@Override
	public ResultSet walletbal(int id) {
		ResultSet rs = null;
		try {
			Connection con = ConnectionUtil.getDbConnection();
			
			String query = "select user_wallet from user_details where user_id = ?";
			PreparedStatement statement = con.prepareStatement(query);
			statement.setInt(1, id);
			rs = statement.executeQuery();

		} catch (SQLException e) {
			
			e.getMessage();
		}
		return rs;
	}

	// update wallet balance:
	@Override
	public int updatewallet(int amount, int userid) {

		Connection con = ConnectionUtil.getDbConnection();
		int res = 0;
		try {
			String query = "update user_details set user_wallet = ? where user_id = ?";
			PreparedStatement statement = con.prepareStatement(query);
			statement.setInt(1, amount);
			statement.setInt(2, userid);
			
			res = statement.executeUpdate();
		} catch (SQLException e) {
			
			e.getMessage();

		}

		return res;

	}

}
