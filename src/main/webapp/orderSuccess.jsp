<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>

<style>
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

body {
	background-image: url('assets/home.jpg');
	background-repeat: no-repeat;
	background-size: cover;
}

h1 {
	margin-top: 200px;
}
</style>

<meta charset="ISO-8859-1">
<title>Order success page</title>
</head>
<body>
	<div class="topnav">
		<a href="home.jsp">Log Out</a>
	    <a href="MyCart"> My Order</a>
	</div>

	<center>
		<h1>Your Order is Placed Successfully!! Thank You!!</h1>

		<h2>
			<i>Your Payment Is Debited From Your Wallet</i>
		</h2>



		<h2>
			<i> Your Wallet Ballance Amount is: ${wallbal}</i>
		</h2>





		<form action="ratingHere.jsp" metohd="post">
			<button type="submit" name="button">Rating</button>
			<br>
			<br> 


		</form>
		</div>
	</center>


</body>
</html>