<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.onlineflowershop.dao.impl.*"
	import="java.sql.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<style>
body {
	background-image: url('assets/home.jpg');
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
<title>Order page</title>
</head>
<body>
	<div class="topnav">

		<a href="aboutUs.jsp">About Us</a> <a href="category.jsp">Category
		</a> <a href="home.jsp">Back To Home</a>
	</div>
	<fieldset id="box">
		<legend>Order Here</legend>
		<form action="OrderSucessServlet">

			<h3>${sessionScope.Price}</h3>
			<h3>${sessionScope.FlowerName}</h3>
			<label for="quantity" id="1">Quantity:<input type="number"
				name="quantity" pattern=[0-9]{2} min=0 required></label><br>
			<br>
			<button type="submit" id="button">Buy</button>
		</form>
	</fieldset>


</body>
</html>


