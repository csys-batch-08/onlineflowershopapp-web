package com.onlineflowershop.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlineflowershop.dao.impl.UserDAOImpl;
import com.onlineflowershop.model.User;


/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String name=request.getParameter("name");
		String emailId=request.getParameter("emailId");
		String password=request.getParameter("password");
		String address=request.getParameter("address");
		long Mobilenumber=Long.parseLong(request.getParameter("Mobilenumber"));
		
		
		User objUserRegister=new User(name,emailId, password,address,Mobilenumber);

		UserDAOImpl user=new UserDAOImpl();
		
		user.insertUser(objUserRegister);
//		RequestDispatcher requestDispatcher=request.getRequestDispatcher("Login.jsp");
//		requestDispatcher.forward(request, response);
		response.sendRedirect("Login.jsp");
	}

}
