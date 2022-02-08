package com.onlineflowershop.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.onlineflowershop.dao.AdminDAO;
import com.onlineflowershop.model.User;
import com.onlineflowershop.util.ConnectionUtil;

public class AdminDAOImpl implements AdminDAO{
	
public  User validateAdmin (String emailId,String password) {

		
		String validateQuery="select * from user_details where role='Admin' and email_id='" +emailId +"'and password='"+password+"'";
		Connection con=ConnectionUtil.getDbConnection();
		User user=null;
		try {
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(validateQuery);
			
			if(rs.next()) {
				user=new User(rs.getString(2),emailId,password,rs.getString(5),rs.getLong(6));
			}		
			
		}
		catch(SQLException e) {
			e.printStackTrace();
			System.out.println("Statement error");
		}
		return user;
		
	}

}

