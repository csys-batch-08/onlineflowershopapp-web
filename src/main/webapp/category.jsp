<%@ page language="java" import="java.sql.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.ResultSet" import="com.onlineflowershop.dao.impl.ProductDAOImpl"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Category page</title>

<style>
body{
background-image:url('assets/home.jpg');
background-repeat:no-repeat;
background-size:cover;
}

table{
margin-left:100px;
margin-top: 100px;

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
  

</style>
</head>
<body>
<div class="topnav" >


   
   <a href="MyCart">My Order</a>    
   <a href="home.jsp">Back To Home</a>
</div>






<form>

<table align="center" border="3">

<th><h3>Category Name</h3></th>
<th><h3>Buy Product</h3></th>

</tr>
<c:forEach var="show" items="${ShowCategory}">

<tr>


<td>${show.catName}</td>

<td><button><a href="CategoryFilterServlet?categoryname=${show.catName}">Buy</a></button></button></button>

</td>
</tr>

</c:forEach>
</table>



</form>
</body>
</html>