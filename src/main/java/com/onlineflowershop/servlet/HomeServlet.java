package com.onlineflowershop.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlineflowershop.dao.impl.ProductDAOImpl;
import com.onlineflowershop.model.Product;

@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ProductDAOImpl proDao = new ProductDAOImpl();

		List<Product> productsList;
		try {
			productsList =proDao.viewProduct();

			for (int i = 0; i < productsList.size(); i++) {
				}

			HttpSession session = request.getSession();
			session.setAttribute("productsList", productsList);
			response.sendRedirect("home.jsp");

		}catch(SQLException e) {
			e.getMessage();
		}
	}

}
