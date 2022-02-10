<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login page</title>

<style>
body {
	margin: 0;
	padding: 0;
	background: url(assets/home.jpg);
	background-repeat: no-repeat;
	background-size: cover;
	
	
	
}
.container {
    
  top: 50%;
	left: 50%;
	position: absolute;
	transform: translate(-50%, -50%);
}



.card{
         padding:60px 40px 50px 40px;
         background: rgb(50,50,50);
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
	background-color:pink;
	color: red;
	cursor: pointer;
}
a {
	font-size: 16px;
}

</style>
</head>
<body>

<form action="LoginServlet" method="post" >


<div class="container">

<div class="card">





<input type="email"    name="emailId" placeholder="Email_id" pattern="[A-Za-z0-9]+[@][a-zA-Z]+[.][a-z]+" autofocus Required><br><br>
<input type="password" name="password" placeholder="Password"   Required><br><br>

<button type="submit" id="button">Login</button><br><br>



</form>
</div>

</div>
</body>
</html>