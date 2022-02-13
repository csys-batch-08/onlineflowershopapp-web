package com.onlineflowershop.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlineflowershop.dao.impl.CartDAOImpl;
import com.onlineflowershop.model.Cart;

/**
 * Servlet implementation class SalesHistoryServlet
 */
@WebServlet("/SalesHistoryServlet")
public class SalesHistoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  @Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      try {
	  CartDAOImpl CartDao=new CartDAOImpl();
	  List<Cart> orderlist=CartDao.showCart();
	  
	  request.setAttribute("showCart", orderlist);
	  RequestDispatcher rd=request.getRequestDispatcher("salesHistory.jsp");
	  rd.forward(request, response);
	  }catch(SQLException e) {
		  e.getMessage();
		  
	  }
  }
}
