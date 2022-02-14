<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
<title>Add Product</title>
</head>
<body>
	<div class="topnav">
		<a href="admin.jsp">Back To Admin</a>

	</div>
	<fieldset id="box">

			<form action="AddProductServlet" method="post">

				Flower_Name: <input type="text" name="flowerName"><br>
				<br> Flower_Description:<input type="text"name="flowerDescription"><br>
				<br> Color: <input type="text" name="flowerColor"><br>
				<br> Retail_Price: <input type="text" name="flowerRetailPrice"><br>
				<br> Category_Name: <input type="text" name="categoryName"><br>
				<br>

				<button type="submit" name="buttton">Add</button>

			</form>
				

	</fieldset>
</body>
</html>