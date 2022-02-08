package com.onlineflowershop.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.onlineflowershop.dao.WalletDAO;
import com.onlineflowershop.util.ConnectionUtil;

public  class WalletDAOImpl implements WalletDAO {
	
	
	public  int walletbal(int userId) 
	{
		int wallet=0;
		try {
		Connection con = ConnectionUtil.getDbConnection();
		String query = "select walllet from user_details where user_id = ?";
		PreparedStatement statement = con.prepareStatement(query);
		statement.setInt(1, userId);
		ResultSet rs = statement.executeQuery();
		if(rs.next()) {
				wallet= rs.getInt(1);
				
				return wallet;
		}}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return wallet;
	}

//update wallet balance:
	public void updatewallet(double amount,int userId) {
		Connection con = ConnectionUtil.getDbConnection();
		String query = "update user_details set walllet = ? where user_id = ?";
		PreparedStatement statement = null;
		
		try {
		statement=con.prepareStatement(query);
		statement.setDouble	(1,amount);
		statement.setInt(2, userId);
		int i = statement.executeUpdate();
		
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			

	}
	
	public int rechargeWallet(String user) {
		
		Connection con = ConnectionUtil.getDbConnection();
		String query = "update user_details set walllet =(walllet+1000) where name = ?";
		PreparedStatement statement = null;
		try {
			statement = con.prepareStatement(query);
			statement.setString(1, user);

			int i = statement.executeUpdate();

			if (i > 0) {
				System.out.println("wallet Updated");
				return 1;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return -1;
		
		
		
		
	}

	
	}


	


