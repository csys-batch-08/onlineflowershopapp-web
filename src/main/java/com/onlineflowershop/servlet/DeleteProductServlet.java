package com.onlineflowershop.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlineflowershop.dao.impl.ProductDAOImpl;

/**
 * Servlet implementation class DeleteProduct
 */
@WebServlet("/DeleteProductServlet")
public class DeleteProductServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			ProductDAOImpl productDao = new ProductDAOImpl();
			int flowerId = Integer.parseInt(request.getParameter("FlowerId"));
			productDao.deleteProduct(flowerId);

			response.sendRedirect("admin.jsp");

		} catch (SQLException e) {
			e.getMessage();
		}
	}

}
