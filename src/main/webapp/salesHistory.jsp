<%@page import="java.util.List" import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import="com.onlineflowershop.dao.impl.*"
	import="com.onlineflowershop.model.*" pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html lang="en">
<head>
<style type="text/css">
table, th, td {
	background-image: linear-gradient(rgba(0, 0, 0, 0.1), rgba(0, 0, 0, 0.1));
	border: 1px solid white;
	border-collapse: collapse;
	padding: 20px;
}

body {
	background-image: url(assets/home1.jpeg.jpg);
	background-repeat: no-repeat;
	background-size: cover;
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
	background-color: pink;
	color: black;
}
</style>
<meta charset="ISO-8859-1">
<title>ShowUser page</title>
</head>

<body>
	<div class="topnav">

		<a href="aboutUs.jsp">About Us</a> <a href="admin.jsp">Back To Admin</a>
	</div>
	<form>
		<table>
			<tr>
			    <th style="color: white">Flower Id</th>
				<th style="color: white">Order Quantity</th>
				<th style="color: white">Total Price</th>
				<th style="color: white">User Id</th>
				<th style="color: white">Order Date</th>
			</tr>
			<c:forEach var="show" items="${showCart}">
				<tr>
					<td style="color: white">${show.productId}</td>
					<td style="color: white">${show.orderQuantity}</td>
					<td style="color: white">${show.totalPrice}</td>
					<td style="color: white">${show.userId}</td>
					<td style="color: white">${show.orderDate}</td>
				</tr>
			</c:forEach>
		</table>
	</form>
</body>
</html>