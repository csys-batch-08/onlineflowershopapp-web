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
 * Servlet implementation class CategoryFilterServlet
 */
@WebServlet("/CategoryFilterServlet")
public class CategoryFilterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String categoryname = request.getParameter("categoryname");
		ProductDAOImpl productDao = new ProductDAOImpl();
		List<Product> viewList;
		try {
			viewList = productDao.showCategoryList(categoryname);
			request.setAttribute("showCategory", viewList);
			RequestDispatcher rd = request.getRequestDispatcher("categoryFilter.jsp");
			rd.forward(request, response);

		} catch (SQLException e) {
			e.getMessage();
		}
	}

}
