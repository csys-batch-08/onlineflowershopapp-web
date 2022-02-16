package com.onlineflowershop.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlineflowershop.dao.impl.WalletDAOImpl;

/**
 * Servlet implementation class CheckWallet
 */
@WebServlet("/CheckWalletServlet")
public class CheckWalletServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		String name = session.getAttribute("CurrentUser1").toString();

		try {
			WalletDAOImpl walletCheck = new WalletDAOImpl();

			walletCheck.rechargeWallet(name);

			response.sendRedirect("order.jsp");

		} catch (SQLException e) {
			e.getMessage();
		}
	}
}
