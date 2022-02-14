<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>login page</title>


<style>
body {
	margin: 0;
	padding: 0;
	background-image: url(assets/home.jpg);
	background-size: cover;
}

.container {
	top: 50%;
	left: 50%;
	position: absolute;
	transform: translate(-50%, -50%);
}

.card {
	padding: 60px 40px 50px 40px;
	background: rgb(50, 50, 50);
	border-radius: 10px;
}

#name {
	width: 200px;
	border: none;
	background: transparent;
	border-bottom: 1px solid white;
	padding: 6px;
	margin-bottom: 20px;
	color: white;
}

#button {
	border-radius: 20px;
	padding: 10px 20px;
	background: blue;
	color: white;
	margin-top: 20px;
	border: none;
	outline: none;
	margin-left: 50px;
}

#button:hover {
	background-color: back;
	color: red;
	cursor: pointer;
}

a {
	font-size: 16px;
}
</style>


</head>
<body>
	<form action="RegisterServlet" method="post">
		<div class="container">
			<div class="card">
				<input type="text" name="name" placeholder="Name" autofocus Required><br>
				<input type="emailId" name="emailId"
					placeholder="Email_id" pattern="[A-Za-z0-9]+[@][a-zA-Z]+[.][a-z]+"
					Required><br>
				 <input type="password" name="password"
					placeholder="Password" pattern="[a-z0-9]{8}" Required><br>
				 <input type="text" name="address" placeholder="address "
					pattern="[0-9a-z]+[,][A-Za-z]+[,][0-9]{6}" Required><br>
				<input type="Mobilenumber" name="Mobilenumber"
					placeholder="mobilenumber" pattern="[0-9]{10}" Required><br>
				<br>

				<button type="submit" id="button">Register</button>
				<br>
				<br>
				<button type="reset" id="button">Reset</button>
				<br>
				<br>
	</form>
	</div>
	</div>

</body>
</html>