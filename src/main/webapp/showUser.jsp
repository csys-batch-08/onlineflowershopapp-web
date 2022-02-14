<%@page import="java.util.List" import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import="com.onlineflowershop.dao.impl.*" pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<style type="text/css">
table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
	padding: 20px;
}

body {
	background-image: url(assets/home.jpg);
	background-repeat: no-repeat;
	background-size: cover;
}
</style>
<meta charset="ISO-8859-1">
<title>Show User page</title>
</head>
<body>
	<form>

		<table>

			<tr>
				<th>User Id</th>
				<th>Name</th>
				<th>Email Id</th>
				<th>Password</th>
				<th>Address</th>
				<th>Mobile Number</th>
				<th>Role</th>
				<th>Wallet
				<th>
			</tr>

			<c:forEach var="show" items="${viewAllUser}">
				<tr>
					<td>${show.userId}</td>
					<td>${show.name}</td>
					<td>${show.emailId}</td>
					<td>${show.password}</td>
					<td>${show.address}</td>
					<td>${show.mobileNumber}</td>
					<td>${show.role}</td>
					<td>${show.wallet}</td>

				</tr>
			</c:forEach>
		</table>
	</form>
</body>
</html>