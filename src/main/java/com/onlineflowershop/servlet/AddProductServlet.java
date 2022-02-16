package com.onlineflowershop.servlet;

import java.io.IOException;

import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlineflowershop.dao.impl.ProductDAOImpl;
import com.onlineflowershop.model.Product;

@WebServlet("/AddProductServelt")
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ProductDAOImpl productDao = new ProductDAOImpl();
		String flower_Name = request.getParameter("flowerName");
		String flower_Description = request.getParameter("flowerDescription");
		String color = request.getParameter("flowerColor");
		double retail_Price = Double.parseDouble(request.getParameter("flowerRetailPrice"));
		String category_Name = request.getParameter("categoryName");

		Product product = new Product(0, flower_Name, flower_Description, color, retail_Price, category_Name, 0, null);

		try {
			productDao.insertProduct(product);
		} catch (SQLException e) {
			e.getMessage();
		}

		response.sendRedirect("admin.jsp");

	}

}
