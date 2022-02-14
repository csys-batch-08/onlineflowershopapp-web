package com.onlineflowershop.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlineflowershop.dao.impl.UserDAOImpl;
import com.onlineflowershop.model.User;

@WebServlet("/ShowUser")
public class ShowUserServlet extends HttpServlet {
	
	
	private static final long serialVersionUID=1L;
	
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)  {
		try {
		UserDAOImpl userDao= new UserDAOImpl();
		List<User> userlist;
		userlist=userDao.showUser();
		
		request.setAttribute("viewAllUser",userlist);
		RequestDispatcher rd =request.getRequestDispatcher("showUser.jsp");
		
			rd.forward(request, response);
		} catch (ServletException e) {
			
			e.getMessage();
		} catch (IOException e) {
			
			e.getMessage();
		}
	}

}
