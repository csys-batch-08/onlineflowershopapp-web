package com.onlineflowershop.dao;

import java.sql.SQLException;

public interface WalletDAO {

	public int walletbal(int id) throws SQLException;

	public void updatewallet(double wallbal, int userid) throws SQLException;

}
