<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html >
<head>
<meta charset="ISO-8859-1">
<style>
body {
	background-image: url(assets/home.jpg);
	background-repeat: no-repeat;
	background-size: cover;
}
h3 { text-align: center; } ​
</style>
<title>Rating here</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<form action="RatingServlet">

		<h3>Please Add Your Rating</h3>

		<input type="number" name="Rating" placeholder="upto 5 rating"
			pattern="[0-9]{5}">
		

		<button type="submit" id="rating">Rating</button>

	</form>
	
</body>
</html>
