package com.onlineflowershop.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlineflowershop.dao.impl.ProductDAOImpl;

@WebServlet("/UpdateProductServlet")
public class UpdateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			
			ProductDAOImpl productDao = new ProductDAOImpl();
			String new_Flower_Name = request.getParameter("newflowerName");
			String old_Flower_Name = request.getParameter("oldflowerName");
			int id;
			id = productDao.findProductId1(old_Flower_Name);
			productDao.updateProduct(new_Flower_Name, id);
			response.sendRedirect("admin.jsp");
		} catch (SQLException e) {

			e.getMessage();
		}

	}

}
