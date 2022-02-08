package com.onlineflowershop.servlet;

import java.io.IOException;
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
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckWalletServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
        HttpSession session=request.getSession();
		
		String Name=session.getAttribute("CurrentUser1").toString();	
		System.out.println("userName"+Name);
	
		WalletDAOImpl WalletCheck=new WalletDAOImpl();
		
		WalletCheck.rechargeWallet(Name);
		
		response.sendRedirect("ShowProduct.jsp");
		
		
		
		
		
		
		
		
		
	}

}
