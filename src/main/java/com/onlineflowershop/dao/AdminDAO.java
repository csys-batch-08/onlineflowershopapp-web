package com.onlineflowershop.dao;

import java.sql.SQLException;

import com.onlineflowershop.model.User;

public interface AdminDAO {

	public User validateAdmin(String emailId, String password) throws SQLException;

}
