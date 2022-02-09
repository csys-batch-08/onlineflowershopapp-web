package com.onlineflowershop.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlineflowershop.dao.impl.ProductDAOImpl;

/**
 * Servlet implementation class AddProductServlet
 */

@WebServlet("/AddProductServelt")
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddProductServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		ProductDAOImpl proDao = new ProductDAOImpl();
		String flower_name = request.getParameter("flowerName");
		String flower_description = request.getParameter("flowerDescription");
		String color = request.getParameter("flowerColor");
		double retail_price = Double.parseDouble(request.getParameter("flowerRetailPrice"));
		String category_name = request.getParameter("categoryName");

		// Product product=new
		// Product(flower_name,flower_description,color,retail_price,category_name);
//		proDao.insertProduct(product);

		response.sendRedirect("admin.jsp");

		doGet(request, response);
	}

}
