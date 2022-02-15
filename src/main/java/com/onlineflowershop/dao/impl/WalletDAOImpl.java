package com.onlineflowershop.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.onlineflowershop.dao.WalletDAO;
import com.onlineflowershop.util.ConnectionUtil;

public class WalletDAOImpl implements WalletDAO {

	public int walletbal(int userId) throws SQLException {
		int wallet = 0;
		Connection con = null;
		PreparedStatement statement = null;
		try {
			con = ConnectionUtil.getDbConnection();
			String balancequery = "select walllet from user_details where user_id = ?";
			statement = con.prepareStatement(balancequery);
			statement.setInt(1, userId);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				wallet = rs.getInt(1);

				return wallet;
			}
		} catch (SQLException e) {

			e.getMessage();
		} finally {
			if (statement != null) {
				statement.close();
			}
			if (con != null) {
				con.close();
			}
		}

		return wallet;
	}

//update wallet balance:
	public void updatewallet(double amount, int userId) throws SQLException {
		Connection con = null;
		String updatequery = "update user_details set walllet = ? where user_id = ?";
		PreparedStatement statement = null;

		try {
			con = ConnectionUtil.getDbConnection();
			statement = con.prepareStatement(updatequery);
			statement.setDouble(1, amount);
			statement.setInt(2, userId);
			statement.executeUpdate();

		} catch (SQLException e) {

			e.getMessage();
		} finally {
			if (statement != null) {
				statement.close();
			}
			if (con != null) {
				con.close();
			}
		}

	}

	public int rechargeWallet(String user) throws SQLException {

		Connection con = null;
		String query = "update user_details set walllet =(walllet+1000) where name = ?";
		PreparedStatement statement = null;
		try {
			con = ConnectionUtil.getDbConnection();
			statement = con.prepareStatement(query);
			statement.setString(1, user);

			int i = statement.executeUpdate();

			if (i > 0) {

				return 1;
			}

		} catch (SQLException e) {

			e.getMessage();
		} finally {
			if (statement != null) {
				statement.close();
			}
			if (con != null) {
				con.close();
			}
		}

		return -1;

	}

}
