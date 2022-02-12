package com.onlineflowershop.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlineflowershop.dao.impl.ProductDAOImpl;
import com.onlineflowershop.model.Product;


@WebServlet("/ShowRating")
public class ShowRating extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
		ProductDAOImpl product=new ProductDAOImpl();
		List<Product> showrating=product.ShowRating();
		
		request.setAttribute("ShowRatings", showrating);
		
		
		
		}catch(SQLException e) {
			e.getMessage();
		}
	}

}
