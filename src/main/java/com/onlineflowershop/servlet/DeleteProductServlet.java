package com.onlineflowershop.servlet;

import java.io.IOException;

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

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		ProductDAOImpl productDao = new ProductDAOImpl();
		int flower_id = Integer.parseInt(request.getParameter("FlowerId"));
		productDao.deleteProduct(flower_id);

		response.sendRedirect("admin.jsp");

	}

}
