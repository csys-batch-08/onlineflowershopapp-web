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
<title>Delete Product</title>
</head>
<body>
	<div class="topnav">

		<a href="aboutUs.jsp">About Us</a> <a href="admin.jsp">Back To
			Admin</a>
	</div>

	<fieldset id="box">
		<form action="DeleteProductServlet" method="post">

			FlowerId:<input type="number" name="FlowerId"><br><br>
			

			<button type="submit" id="button">delete</button>

		</form>
	</fieldset>
</body>
</html>