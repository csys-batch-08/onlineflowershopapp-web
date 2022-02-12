package com.onlineflowershop.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlineflowershop.dao.impl.ProductDAOImpl;



@WebServlet("/AddProductServelt")
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

		ProductDAOImpl proDao = new ProductDAOImpl();
		String flower_name = request.getParameter("flowerName");
		String flower_description = request.getParameter("flowerDescription");
		String color = request.getParameter("flowerColor");
		double retail_price = Double.parseDouble(request.getParameter("flowerRetailPrice"));
		String category_name = request.getParameter("categoryName");

	

		response.sendRedirect("admin.jsp");

		doGet(request, response);
	}

}
