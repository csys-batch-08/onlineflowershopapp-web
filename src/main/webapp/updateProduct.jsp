<%@page import="java.util.List" import ="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
     pageEncoding="ISO-8859-1" import ="com.onlineflowershop.dao.impl.*" %>
    
    
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
     
<!DOCTYPE html>
<html>
<head>
<style>
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

.topnav a:hover
 
{
  background-color:pink;
  color:black ;
  }
  





</style>


<meta charset="ISO-8859-1">
<title>Update Product </title>
</head>
<body>
<div class="topnav" >

   <a href="AboutUs.jsp">About Us</a>
   
    
   <a href="Admin.jsp">Back To Admin</a>
</div>

<table border="2">
<tr>
<th>Flower Name</th>

</tr>
<c:forEach var="update" items="${updateProduct}">

<tr>
<td>${update.flowerName}</td>

</tr>

</table>
</c:forEach>




<fieldset id="box"><center>
<form action="UpdateProduct" method="post">

 Old Flower Name:<input type="text" name="oldflowerName"><br><br>
 
 New Flower Name:<input type="text" name="newflowerName"><br><br>
 
 <button type="submit" id="button"> submit</button>
 
 
 
 

</form>

 </center>
</fieldset>
<a href="home.jsp">Back To Home Page</a>

</body>
</html>