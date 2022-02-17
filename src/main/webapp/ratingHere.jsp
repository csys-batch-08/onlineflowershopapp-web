<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<style>
body {
	background-image: url(assets/home.jpg);
	background-repeat: no-repeat;
	background-size: cover;
}
h3 { text-align: center; }

.center {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 200px;
  
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
 ​
</style>
<title>Rating here</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<div class="topnav">
<a href="CategoryServlet">Category</a>
		 <a href="MyCart">My Order</a>
			<a href="home.jsp">Back To Home </a>
</div>	
<form action="RatingServlet">

		<h3>Please Add Your Rating</h3>
        <div class=center>
		<input type="number" name="Rating" placeholder="upto 5 rating"
			pattern="[0-9]{5}">
		

		<button type="submit" id="rating">Rating</button><div>

	</form>

</body>
</html>
