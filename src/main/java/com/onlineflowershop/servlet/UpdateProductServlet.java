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
 * Servlet implementation class UpdateProductServlet
 */
@WebServlet("/UpdateProductServlet")
public class UpdateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			System.out.println("product");
			ProductDAOImpl productDao = new ProductDAOImpl();
			String new_flower_name = request.getParameter("newflowerName");
			String old_flower_name = request.getParameter("oldflowerName");
			int id;
			id = productDao.findProductId1(old_flower_name);
			productDao.updateProduct(new_flower_name, id);
			response.sendRedirect("admin.jsp");
		} catch (SQLException e) {

			e.getMessage();
		}

	}

}
