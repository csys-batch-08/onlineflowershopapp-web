<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<htmllang"en">
<head>
<meta charset="ISO-8859-1">
<title>Home page</title>
<style>
body {
	background-image: url("assets/index2.jpg");
	background-repeat: no-repeat;
	background-size: cover;
	color: black;
}

.topnav {
	background-color: gray;
	overflow: hidden;
}

h1 {
	text-align: center;
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

.topnav a.active {
	color: white;
}
</style>
</head>
<body>
	<h1>
		<em>Welcome To My Bloom Shop</em>
	</h1>
	<div class="topnav">
		<a class="active" href="login.jsp">Login</a> <a href="register.jsp">Register</a>
		<a href="aboutUs.jsp">About Us</a> <a href="checkWallet">Recharge
			Wallet</a>
	</div>
</body>
</html>