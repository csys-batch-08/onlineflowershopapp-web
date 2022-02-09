package com.onlineflowershop.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlineflowershop.dao.impl.UserDAOImpl;
import com.onlineflowershop.model.User;

/**
 * Servlet implementation class Register
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name");
		String emailId = request.getParameter("emailId");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		long Mobilenumber = Long.parseLong(request.getParameter("Mobilenumber"));

		User objUserRegister = new User(name, emailId, password, address, Mobilenumber);

		UserDAOImpl user = new UserDAOImpl();

		try {
			response.sendRedirect("login.jsp");
			user.insertUser(objUserRegister);

		} catch (Exception e) {
			e.getMessage();
		}
	}
}
