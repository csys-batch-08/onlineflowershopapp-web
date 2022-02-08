package com.onlineflowershop.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlineflowershop.dao.impl.RatingDAOImpl;

/**
 * Servlet implementation class RatingServlet
 */
@WebServlet("/RatingServlet")
public class RatingServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 HttpSession session=request.getSession();
		 
		 int newRating=Integer.parseInt(request.getParameter("Rating"));
		 RatingDAOImpl ratingDao=new RatingDAOImpl();
		 int flowerId=Integer.parseInt(session.getAttribute("flower_id").toString());
		 
		 String flowerName=(String) session.getAttribute("flowername");
		 
		// String flowerName=request.getAttribute("flowerName").toString();
		 System.out.println(flowerId);
		 
		 int oldRating=ratingDao.findRating(flowerName);
		 int rating=oldRating+newRating;
		 
		 
		 System.out.println("new rating="+newRating);
		 System.out.println("flower name="+flowerName);
		 System.out.println("oldrating="+oldRating);
		 System.out.println("updated rating="+rating);
		 
		 
		 ratingDao.updateRating(rating, flowerId);
		 response.sendRedirect("Rating.jsp");
		 
		 
		 
		 
	}

}
