package com.onlineflowershop.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlineflowershop.dao.impl.UserDAOImpl;
import com.onlineflowershop.dao.impl.WalletDAOImpl;
import com.onlineflowershop.exception.UserException;
import com.onlineflowershop.model.User;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String emailId = request.getParameter("emailId");
		String password = request.getParameter("password");
		System.out.println("hi"+emailId);

		UserDAOImpl userDao = new UserDAOImpl();
		User currentUser;
		try {
			currentUser = userDao.validateUser(emailId, password);
		
		if (currentUser != null) {
			String role = currentUser.getRole();

			session.setAttribute("currentUser", currentUser);
			String user = currentUser.getName();
			String email = currentUser.getEmailId();
			session.setAttribute("emailId", email);
			System.out.println(email);

			session.setAttribute("username", user);
			int userId = currentUser.getUserId();

			session.setAttribute("userId", userId);
			System.out.println(role);

			if (role.equals("Admin")) {
				System.out.println("admin");
				response.sendRedirect("admin.jsp");
			}

			else if (role.equals("user")) {

				session.setAttribute("currentUser1", currentUser.getName());

				session.setAttribute("currentUser1", currentUser.getName());

				WalletDAOImpl WalletBal = new WalletDAOImpl();
				int WalletBallance = WalletBal.walletbal(userId);

				System.out.println("loginservlet");
				response.sendRedirect("ShowProductServlet");

			}
		}} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 

	}

}
