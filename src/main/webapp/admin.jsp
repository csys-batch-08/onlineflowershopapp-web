<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
	color: #f2f2f2;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
	font-size: 17px;
}

.topnav a:hover {
	background-color: #ddd;
	color: black;
}

.topnav a.active {
	background-color: gray;
	color: white;
}
</style>




<meta charset="ISO-8859-1">
<title>Admin page</title>
</head>
<body>
	<h3>Welcome Admin</h3>

	<form>
		<div class="topnav">

			<a href="home.jsp">LogOut</a>




		</div>
	</form>


	<fieldset id="box">
		<legend>Edit Here</legend>
		<a href="ShowUser">
			<button type="submit" id="button">
				<i>ShowUser</i>
			</button>
		</a><br> <a href="SalesHistoryServlet">
			<button type="submit" id="button">
				<i>SalesHistory</i>
			</button>
		</a><br> <a href="updateProduct.jsp">
			<button type="submit" id="button">
				<i>UpdateProduct</i>
			</button>
		</a><br> <a href="addProduct.jsp">
			<button type="submit" id="button">
				<i> AddProduct</i>
			</button>
		</a><br> <a href="deleteProduct.jsp">
			<button type="submit" id="button">
				<i>DeleteProduct</i>
			</button>
		</a><br>


	</fieldset>

</body>
</html>