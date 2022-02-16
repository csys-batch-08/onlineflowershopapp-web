package com.onlineflowershop.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlineflowershop.dao.impl.CartDAOImpl;
import com.onlineflowershop.dao.impl.WalletDAOImpl;
import com.onlineflowershop.model.Cart;


@WebServlet("/OrderSucessServlet")
public class OrderSucessServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		try {

			int quantity = Integer.parseInt(request.getParameter("quantity"));
			String name = (String) session.getAttribute("User");
	

			double retailPrice = Double.parseDouble(session.getAttribute("Price").toString());

			double totalPrice = (retailPrice * quantity);
			session.setAttribute("TotalPrice", totalPrice);
			request.setAttribute("TotalPrice", totalPrice);

		

			WalletDAOImpl walletDao = new WalletDAOImpl();

			int wallet;
			int userId = Integer.parseInt(session.getAttribute("userId").toString());
			wallet = walletDao.walletbal(userId);

			double wallbal = wallet - totalPrice;

			session.setAttribute("wallbal", wallbal);
			request.setAttribute("wallbal", wallbal);

		    walletDao.updatewallet(wallbal, userId);

			int flowerId = Integer.parseInt(session.getAttribute("FlowerId").toString());
			session.setAttribute("flower_id", flowerId);

			Cart cart = new Cart(0, flowerId, null, userId, name, null, quantity, totalPrice, null);

			CartDAOImpl cartDao = new CartDAOImpl();
			cartDao.insertCart(cart);
			response.sendRedirect("orderSuccess.jsp");
		} catch (SQLException e) {

			e.getMessage();
		}

	}

}
