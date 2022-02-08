package com.onlineflowershop.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlineflowershop.dao.impl.CartDAOImpl;
import com.onlineflowershop.dao.impl.UserDAOImpl;
import com.onlineflowershop.dao.impl.WalletDAOImpl;
import com.onlineflowershop.model.Cart;
import com.onlineflowershop.model.User;


/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 HttpSession session=request.getSession();
		 int quantity=Integer.parseInt(request.getParameter("quantity"));		 
		 String name=(String) session.getAttribute("User");
		 UserDAOImpl userDao=new UserDAOImpl();
		 	
		 double retailPrice=Double.parseDouble(session.getAttribute("retailPrice").toString());				
		 
		 		 double totalPrice=(retailPrice*quantity);		 		 
		 
		 	WalletDAOImpl walletDao=new WalletDAOImpl();
		 	int userId=Integer.parseInt(session.getAttribute("userId").toString());
		 	
		 	int Wallet=walletDao.walletbal(userId);		 				 	
			 	
		 	double wallbal =Wallet-totalPrice;
		 	
		 	session.setAttribute("wallbal", wallbal);
		 	
		 	 session.setAttribute("totalPrice", totalPrice);
		 	
		 	 Date order=(Date) session.getAttribute("orderDate");

		 	walletDao.updatewallet(wallbal,userId);
		 	
		 	int flowerId=Integer.parseInt(session.getAttribute("flower_id").toString());
		 	session.setAttribute("flower_id", flowerId);
		 	
		 	Cart cart=new Cart(flowerId,userId,quantity,totalPrice);
		 	
		 	CartDAOImpl cartDao=new CartDAOImpl();
            cartDao.insertCart(cart);
		 response.sendRedirect("OrderSuccess.jsp");	
		 
		 
	}

}
