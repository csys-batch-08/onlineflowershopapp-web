package com.onlineflowershop.dao;

import com.onlineflowershop.model.User;

public interface AdminDAO {
	
	public  User validateAdmin (String emailId,String password);


}
