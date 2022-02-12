package com.onlineflowershop.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlineflowershop.dao.impl.UserDAOImpl;
import com.onlineflowershop.model.User;

@WebServlet("/ShowUserServlet")
public class ShowUserServlet extends HttpServlet {
	
	
	private static final long serialVersionUID=1L;
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		UserDAOImpl userDao= new UserDAOImpl();
		List<User> viewAllUser=userDao.showUser();
		request.setAttribute("showUser",viewAllUser);
		RequestDispatcher rd =request.getRequestDispatcher("showUser.jsp");
		rd.forward(request, response);
		
		
		
	}

}
