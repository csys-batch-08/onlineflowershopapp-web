<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.sql.ResultSet"
	import="com.onlineflowershop.dao.impl.CartDAOImpl"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>My Order Page</title>
<style type="text/css">
table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
	padding: 20px;
}

body {
	background-image: url('assets/home.jpg');
	background-repeat: no-repeat;
	background-size: cover;
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
	<div class="topnav">
		<a href="CategoryServlet">Category</a> <a href="aboutUs.jsp">About
			Us</a> <a href="home.jsp">LogOut</a>
	</div>

	<form>
		<table align="center">
			<tr>
				<th>Order Id</th>
				<th>Flower Name</th>
				<th>Order quantity</th>
				<th>Total price</th>
				<th>Order Date</th>

			</tr>
			<c:forEach var="show" items="${viewOrder}">
				<tr>
					<td>${show.cartId}</td>
					<td>${show.flowerName}</td>
					<td>${show.orderQuantity}</td>
					<td>${show.totalPrice}</td>
					<td>${show.orderDate}</td>

				</tr>
			</c:forEach>
		</table>
	</form>
</body>
</html>