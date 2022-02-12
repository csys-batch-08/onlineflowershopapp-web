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
		String flower_name = request.getParameter("flowerName");
		String flower_description = request.getParameter("flowerDescription");
		String color = request.getParameter("flowerColor");
		double retail_price = Double.parseDouble(request.getParameter("flowerRetailPrice"));
		String category_name = request.getParameter("categoryName");
		
		
		
		Product product =new Product(0,flower_name,flower_description,color,retail_price,category_name,0,null);

        try {
        	productDao.insertProduct(product);
        }catch(SQLException e) {
        	e.getMessage();
        }

		response.sendRedirect("admin.jsp");

		
	}

}
