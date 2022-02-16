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
import com.onlineflowershop.model.User;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String emailId = request.getParameter("emailId");
		String password = request.getParameter("password");

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

				session.setAttribute("username", user);
				int userId = currentUser.getUserId();

				session.setAttribute("userId", userId);

				if (role.equals("Admin")) {
					
					response.sendRedirect("admin.jsp");
				}

				else if (role.equals("user")) {

					session.setAttribute("currentUser1", currentUser.getName());

					WalletDAOImpl WalletBal = new WalletDAOImpl();
					int walletBallance = WalletBal.walletbal(userId);

					response.sendRedirect("ShowProductServlet");

				}
			}
		} catch (SQLException e1) {

			e1.getMessage();
		}

	}

}
