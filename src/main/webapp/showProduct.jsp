<%@page import="java.text.DecimalFormat"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
     pageEncoding="ISO-8859-1" import ="com.onlineflowershop.dao.impl.*" %>
     
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
     
     
     
<!DOCTYPE html>
<html lang="en">
<head>
<style type="text/css">
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
  padding: 20px;
}

body{
background-image:url(assets/home.jpg);
background-repeat:no-repeat;
background-size:cover;
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
  background-color:pink;
  color:black ;
  }
  


#button {
	border-radius: 20px;
	padding: 10px 20px;
	background:blue;
	color: black;
	margin-top: 20px;
	border: none;
	outline: none;
	margin-left: 50px;
}



#button:hover {
	background-color:pink;
	color: black;
	cursor: pointer;


</style>
<meta charset="ISO-8859-1">
<title>Show Product Page</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>




</head>
<body>
<form>






<div class="topnav" >
  
  
  <a href="Category.jsp">Category</a>
  <a href="MyCart.jsp">My Order</a>
  <a href="Home.jsp">Back To Home </a>
 
   
  



<table align="center" class="table table-hover">
<tr>
<th>Picture</th>
<th style=color:black>Flower Name</th>
<th style=color:black>Flower Description</th>
<th style=color:black>Color</th>
<th style=color:black>Flower Retail price</th>
<th style=color:black>Flower Category</th>
<th style=color:black>Flower Rating</th>
<th style=color:black>Buy Product</th>
</tr>

<c:forEach var="view" items="${viewProduct}">

<tr>
<td><img src="${view.picture}" alt="#alter" width="200" height="200"></td>
<td>${view.flowerName}</td>
<td>${view.flowerDescription}</td>
<td>${view.color}</td>
<td>${view.retailPrice}</td>
<td>${view.catName}</td>
<td>${view.rating}</td>
<td><button class="button button1"><a href="order?flowerId=${view.flowerId}&flowerName=${view.flowerName}&retailPrice=${view.retailPrice}"style="text-decoration:none;">Buy</a></button></td>
</tr>
</c:forEach>

</table>


</div>
</form>
</body>
</html>