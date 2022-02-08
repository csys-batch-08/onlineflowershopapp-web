package com.onlineflowershop.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlineflowershop.dao.impl.ProductDAOImpl;

/**
 * Servlet implementation class UpdateProductServlet
 */
@WebServlet("/UpdateProduct")
public class UpdateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
    public UpdateProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		ProductDAOImpl productDao=new ProductDAOImpl();
		String new_flower_name=request.getParameter("newflowerName");
		String old_flower_name=request.getParameter("oldflowerName");
		int id=productDao.findProductId1(old_flower_name);
		
		productDao.updateProduct(new_flower_name,id);
		
		response.sendRedirect("Admin.jsp");
		
		
		
		
		
//		doGet(request, response);
	}

}
