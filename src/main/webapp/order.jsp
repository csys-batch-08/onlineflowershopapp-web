<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.onlineflowershop.dao.impl.*" import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<style>
body{
background-image:url('assets/home.jpg');
background-repeat:no-repeat;
background-size:cover;
}

.topnav {
  background-color: gray;
  overflow: hidden;
}

.topnav a {
  float: left;
  color: pink;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}

.topnav a:hover {
  background-color:pink;
  color:black ;
  }


</style>


<meta charset="ISO-8859-1">
<title>Order page</title>
</head>
<body>
<div class="topnav" >

   <a href="AboutUs".jsp">About Us</a>
   <a href="Category.jsp">Category </a>
    
   <a href="Home.jsp">Back To Home</a>
</div>


<%int flowerId=Integer.parseInt(request.getParameter("flowerId")); 
	
	session.setAttribute("flower_id",flowerId);
	
	String flowerName=request.getParameter("flowerName");
	System.out.println("Order Flower Name: "+flowerName);
	session.setAttribute("flowername", flowerName);
	
ProductDAOImpl productDao=new ProductDAOImpl();
ResultSet rs=productDao.findPrice(flowerId);



String name=session.getAttribute("username").toString();
//System.out.println(name);

%>
<center>
<fieldset id="box">
<form action="OrderServlet" method="post">
<%while(rs.next()){%>
			
			
			
<h3><%= rs.getString(2) %></h3>
			
<h1><%double price=rs.getDouble(5);%></h1>
			
<h3>Price :<%= price%></h3><br>	
<%session.setAttribute("retailPrice", price); %>		
Quantity:<input type="number" name="quantity" pattern=[0-9]{2} min=0 required><br><br>
				
				
								
<button type="submit" id="button">Buy</button>
				
<%} %>
			
</form>
</fieldset>
</center>

</body>
</html>


