<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.ResultSet" import="com.onlineflowershop.dao.impl.*"%>
<!DOCTYPE html>
<html>
<head>
<style>
body{
background-image:url('assets/home.jpg');
background-repeat:no-repeat;
background-size:cover;
}

</style>

<meta charset="ISO-8859-1">
<title>Order Success</title>
</head>
<body>

<h3><i>your Rating was Added Successfully!!</i></h3>


<%
ProductDAOImpl product=new ProductDAOImpl();
ResultSet rs=product.ShowRating();
%>

<h2><i>Highly Rated Flower</i></h2>
<table align="left" border="5">

<th><h3>Flower Name</h3></th>
<th><h3>Ratings</h3></th>


<% while(rs.next()){%>
<tr>
<td><%= rs.getString(1) %></td>
<td><%= rs.getInt(2) %></td>
</tr>
<%} %>

</table>


</form><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<a href="Home.jsp">Back To Home Page</a>
</body>
</html>