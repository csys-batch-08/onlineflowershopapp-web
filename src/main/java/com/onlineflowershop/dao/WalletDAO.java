package com.onlineflowershop.dao;

import java.sql.SQLException;

public interface WalletDAO {

	public int walletbal(int id) throws SQLException;

	public void updatewallet(double amount, int userId) throws SQLException;
	
	public int rechargeWallet(String user) throws SQLException;

}
