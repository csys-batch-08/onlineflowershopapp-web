package com.onlineflowershop.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		double price = Double.parseDouble(request.getParameter("retailPrice"));
		System.out.println(price);
		session.setAttribute("Price", price);
		String flowerName = request.getParameter("flowerName");
		session.setAttribute("FlowerName", flowerName);
		String flowerId = request.getParameter("flowerId");
		session.setAttribute("FlowerId", flowerId);
		System.out.println(flowerId);

		response.sendRedirect("order.jsp");

	}

}
