<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import ="java.sql.*" import ="com.onlineflowershop.dao.impl.*"%>
<!DOCTYPE html>
<html>
<head>

<style>
table,th,td{
 border: 1px solid white;
  border-collapse: collapse;
  padding: 20px;
}

body{
background-image:url('assets/home.jpg');
background-repeat:no-repeat;
background-size:cover;
}

</style>

<meta charset="ISO-8859-1">
<title>Category of flower</title>
</head>
<body>

<form>



<%
String categoryname=request.getParameter("categoryname");
System.out.println(categoryname);
ProductDAOImpl productDao=new ProductDAOImpl();
ResultSet rs=productDao.showCategoryList(categoryname);
%>
<table>
<tr>
<th>Picture</th>
<th style=color:black>Flower Name</th>
<th style=color:black>Flower Description</th>
<th style=color:black>Color</th>
<th style=color:black>Flower Retail price</th>
<th style=color:black>Flower Category</th>
<th style=color:black>Flower Rating</th>
<th style=color:black>Buy Product</th>
</tr>
<%while(rs.next()){%>
<tr>
<td><img alt="#alter" src="<%=rs.getString(8)%>" width="200" height="200"></td>
<td style=color:black><%= rs.getString(2) %></td>
<td style=color:black><%= rs.getString(3) %></td>
<td style=color:black><%= rs.getString(4) %></td>
<td style=color:black><%= rs.getDouble(5) %></td>
<td style=color:black><%= rs.getString(6) %></td>
<td style=color:black><%= rs.getInt(7) %></td>
<td><button><a href="Order.jsp?flowerId=<%=rs.getInt(1)%>&flowerName=<%=rs.getString(2)%>">Buy</a></button></td>
</tr>

<%} %>


</table>












</form>













</body>
</html>