<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
body{
background-image:url(assets/home.jpg);
background-repeat:no-repeat;
background-size:cover;
}


</style>
<meta charset="ISO-8859-1">
<title>Rating here</title>
 <link rel="stylesheet" type="text/css" href="style.css">

</head>
<body>



<center>

<form action="RatingServlet" method="post">

<h3>Please Add Your Rating</h3>

 
<input type="number" name="Rating" placeholder="upto 5 rating" pattern="[0-9]{5}"> </h3>
 
 <button type="submit" id="rating">Rating</button>

</form>

</center>
</body>
</html>
