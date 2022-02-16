package com.onlineflowershop.dao;

import java.sql.SQLException;
import java.util.List;

import com.onlineflowershop.model.User;

public interface UserDAO {

	public void insertUser(User user) throws SQLException;

	public User validateUser(String emailId, String password) throws SQLException;

	public List<User> showUser() throws SQLException;

	public void update(String update) throws SQLException;

	public void deletedetails(String delete) throws SQLException;

	public int findUserId(String userName) throws SQLException;

	

}
