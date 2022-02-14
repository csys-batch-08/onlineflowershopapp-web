<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Wallet check</title>
<style type="text/css">
#box {
	width: 350px;
	margin-left: 600px;
	margin-top: 250px;
}

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

.topnav a.active {
	color: white;
}
</style>
</head>
<body>

	<div class="topnav">
		<a href="home.jsp">Back To Home</a>
	</div>
	<fieldset id="box">
	<legend>Recharge Wallet</legend>
			<h2>Your Wallet Amount is low Please Recharge</h2>
			<form action="checkWallet">
				<button type="submit" id="button">Pay</button>
			</form>
			<br>
			<form action="home.jsp">
				<button type="submit" id="button">Pay Later</button>
			</form>
			

	</fieldset>
</body>
</html>