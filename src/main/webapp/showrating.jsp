<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.ResultSet" import="com.onlineflowershop.dao.impl.*"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<style>
body{
background-image:url('assets/home.jpg');
background-repeat:no-repeat;
background-size:cover;
}

</style>

<meta charset="ISO-8859-1">
<title>Order Success</title>
</head>
<body>
<form>
<h3><i>your Rating was Added Successfully!!</i></h3>




<h2><i>Highly Rated Flower</i></h2>
<table align="left" border="5">
<tr>
<th><h3>Flower Name</h3></th>
<th><h3>Ratings</h3></th>
</tr>
<tr>
<c:forEach var="show" items="${ShowRatings}">
<tbody>
<tr>
<td>${show.flowerName}</td>
<td>${show.rating}</td>
</tr>
</tbody>
</c:forEach>
</table>


</form><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<a href="home.jsp">Back To Home Page</a>
</body>
</html>