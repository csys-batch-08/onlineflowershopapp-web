<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.sql.*"
	import="com.onlineflowershop.dao.impl.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>

<style>
table, th, td {
	border: 1px solid white;
	border-collapse: collapse;
	padding: 20px;
}

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
<title>Category of flower</title>
</head>
<body>
	<form>
		<table>
			<tr>
				<th>Picture</th>
				<th style="color: black">Flower Name</th>
				<th style="color: black">Flower Description</th>
				<th style="color: black">Color</th>
				<th style="color: black">Flower Retail price</th>
				<th style="color: black">Flower Category</th>
				<th style="color: black">Flower Rating</th>
				<th style="color: black">Buy Product</th>
			</tr>
			<c:forEach var="view" items="${showCategory}">

				<tr>
					<td><img  alt="img" src="${view.picture}" width="200" height="200"></td>
					<td style="color: black">${view.flowerName}</td>
					<td style="color: black">${view.flowerDescription}</td>
					<td style="color: black">${view.color}</td>
					<td style="color: black">${view.retailPrice}</td>
					<td style="color: black">${view.catName}</td>
					<td style="color: black">${view.rating}</td>
					<td>
					<button class="button button1">
					<a href="OrderServlet?flowerId=${view.flowerId}&flowerName=${view.flowerName}&retailPrice=${view.retailPrice}"style="text-decoration: none;">Buy</a>
				    </button>
				    </td>
				</tr>
			</c:forEach>
		</table>

	</form>
	<a href="home.jsp">Back To Home</a>
</body>
</html>