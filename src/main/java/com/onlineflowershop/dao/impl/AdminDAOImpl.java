package com.onlineflowershop.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.onlineflowershop.dao.AdminDAO;
import com.onlineflowershop.model.User;
import com.onlineflowershop.util.ConnectionUtil;

public class AdminDAOImpl implements AdminDAO{
	
public  User validateAdmin (String emailId,String password) throws SQLException {

		
		String validateQuery="select user_id,name,email_id,password,address,mobile_number,role,walllet from user_details where role='Admin' and email_id='" +emailId +"'and password='"+password+"'";
		Connection con=null;
		User user=null;
		PreparedStatement pstmt=null;
		try {
			con=ConnectionUtil.getDbConnection();
		    pstmt=con.prepareStatement(validateQuery);
			ResultSet rs=pstmt.executeQuery();
			
			if(rs.next()) {
				user=new User(rs.getString(2),emailId,password,rs.getString(5),rs.getLong(6));
			}		
			
		}
		catch(SQLException e) {
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

}

