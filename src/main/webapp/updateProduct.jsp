<%@page import="java.util.List" import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.onlineflowershop.dao.impl.*"%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<style>
body {
	background-image: url(assets/home.jpg);
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
<title>Update Product</title>
</head>
<body>
	<div class="topnav">

		<a href="aboutUs.jsp">About Us</a> <a href="admin.jsp">Back To
			Admin</a>
	</div>

	       <fieldset id="box"><legend>Update Product</legend>
				
					<form action="UpdateProductServlet" method="post">

						Old Flower Name:<input type="text" name="oldflowerName"><br>
						<br> New Flower Name:<input type="text" name="newflowerName"><br>
						<br>
						<button type="submit" id="button">submit</button>
					</form>
			</fieldset>
</body>
</html>