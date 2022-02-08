package com.onlineflowershop.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlineflowershop.dao.impl.AdminDAOImpl;
import com.onlineflowershop.dao.impl.UserDAOImpl;
import com.onlineflowershop.dao.impl.WalletDAOImpl;
import com.onlineflowershop.exception.UserException;
import com.onlineflowershop.model.User;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		String emailId = request.getParameter("emailId");
		String password = request.getParameter("password");

		UserDAOImpl userDao = new UserDAOImpl();
		User currentUser=userDao.validateUser(emailId, password);
		if(currentUser!=null) {
		String role=currentUser.getRole();
		
		
		session.setAttribute("currentUser", currentUser);
		String user=currentUser.getName();
		String email=currentUser.getEmailId();
		session.setAttribute("emailId", email);
		System.out.println(email);
		
		session.setAttribute("username", user);
		int userId=currentUser.getUserId();
		
		session.setAttribute("userId", userId);
		System.out.println(userId);
	


		if (role.equals("Admin")) {
			
			response.sendRedirect("Admin.jsp");
		}
		
	

		else if (role.equals("user")) {
			
			session.setAttribute("currentUser1",currentUser.getName());
			
			session.setAttribute("currentUser1", currentUser.getName());
			
			WalletDAOImpl WalletBal=new WalletDAOImpl();
			int WalletBallance=WalletBal.walletbal(userId);
			
		if(WalletBallance>1000) {
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("ShowProduct.jsp");
			requestDispatcher.forward(request, response);
			
		}	else {
			
			response.sendRedirect("CheckWallet.jsp");
			
		}
		}
			}
		else{
			try {
				
			throw new UserException();
		
			}catch(UserException e) {
				session.setAttribute("Invalid",e.getMessage());
				response.sendRedirect("Login.jsp");
			}
		}


		

	}

}
