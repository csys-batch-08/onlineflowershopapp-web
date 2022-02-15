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

import com.onlineflowershop.dao.impl.ProductDAOImpl;
import com.onlineflowershop.model.Product;

/**
 * Servlet implementation class CategoryServlet
 */
@WebServlet("/CategoryServlet")
public class CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ProductDAOImpl productDao = new ProductDAOImpl();
		List<Product> viewCategory;

		try {
			viewCategory = productDao.showCategory();
			request.setAttribute("ShowCategory", viewCategory);
			RequestDispatcher rd = request.getRequestDispatcher("category.jsp");
			rd.forward(request, response);
		} catch (SQLException e) {

			e.getMessage();
		}
	}
}
