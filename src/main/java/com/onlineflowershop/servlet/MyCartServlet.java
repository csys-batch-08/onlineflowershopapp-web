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
import javax.servlet.http.HttpSession;

import com.onlineflowershop.dao.impl.CartDAOImpl;
import com.onlineflowershop.model.Cart;

/**
 * Servlet implementation class MyCartServlet
 */
@WebServlet("/MyCartServlet")
public class MyCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		int userId = Integer.parseInt(session.getAttribute("userId").toString());

		CartDAOImpl cartDao = new CartDAOImpl();

		List<Cart> orderlist;
		try {
			orderlist = cartDao.showUserCart(userId);
			request.setAttribute("viewOrder", orderlist);

			String emailId = session.getAttribute("CurrentUser").toString();
			request.setAttribute("UserName", emailId);

			RequestDispatcher rd = request.getRequestDispatcher("myCart.jsp");
			rd.forward(request, response);

		} catch (SQLException e) {
			e.getMessage();
		}
	}

}