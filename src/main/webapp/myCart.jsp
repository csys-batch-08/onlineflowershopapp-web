<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.ResultSet"  import="com.onlineflowershop.dao.impl.CartDAOImpl"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Order Page</title>
<style type="text/css">
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
  padding: 20px;
}
body{
background-image:url('assets/home.jpg');
background-repeat:no-repeat;
background-size:cover;
}

.topnav {
  background-color: Gray;
  overflow: hidden;
}


.topnav a {
  float: left;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}


.topnav a:hover {
  background-color: #ddd;
  color: black;
}


.topnav a.active {
  background-color: gray;
  color: white;
}
</style>


</head>
<body>
<div class="topnav" >
<a href="Category.jsp">Category</a>
<a href="Aboutus.jsp">About Us</a>
<a href="Home.jsp">LogOut</a>

</div>
<% 
int userId=Integer.parseInt(session.getAttribute("userId").toString());
System.out.println(userId);

CartDAOImpl cartDao=new CartDAOImpl();
ResultSet rs=cartDao.showUserCart(userId);
%>

<form>
<table align="center">
<tr>

<th>User Name</th>
<th>Flower Name</th>
<th>Order quantity</th>
<th>Total price</th>

</tr>

<% String emailId=session.getAttribute("currentUser").toString();%>

<%while(rs.next()){%>
<tr>
<td><%= rs.getString(1) %></td>
<td><%= rs.getString(2) %></td>
<td><%= rs.getInt(3) %></td>
<td><%= rs.getDouble(4) %></td>

</tr>
<%} %>
</table>










</form>


</body>
</html>