package com.onlineflowershop.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlineflowershop.dao.impl.ProductDAOImpl;
import com.onlineflowershop.dao.impl.RatingDAOImpl;
import com.onlineflowershop.model.Product;

/**
 * Servlet implementation class RatingServlet
 */
@WebServlet("/RatingServlet")
public class RatingHereServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();

		int newRating = Integer.parseInt(request.getParameter("Rating"));
		RatingDAOImpl ratingDao = new RatingDAOImpl();
		int flowerId = Integer.parseInt(session.getAttribute("flower_id").toString());

		String flowerName = (String) session.getAttribute("flowername");

		

		int oldRating=0;
		try {
			oldRating = ratingDao.findRating(flowerName);
		} catch (SQLException e) {
			
			e.getMessage();
		}
		int rating = oldRating + newRating;

//		System.out.println("new rating=" + newRating);
//		System.out.println("flower name=" + flowerName);
//		System.out.println("oldrating=" + oldRating);
//		System.out.println("updated rating=" + rating);

		try {
			ratingDao.updateRating(rating, flowerId);
			
			ProductDAOImpl product=new ProductDAOImpl();
			List<Product> showrating=product.showRating();
			
			request.setAttribute("ShowRatings", showrating);
			
			response.sendRedirect("showrating.jsp");
			
		} catch (SQLException e) {
			
			e.getMessage();
		}
		

	}

}
