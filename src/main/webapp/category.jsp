<%@ page language="java" import="java.sql.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.ResultSet" import="com.onlineflowershop.dao.impl.ProductDAOImpl"%>
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


   
   <a href="MyCart.jsp">My Order</a>    
   <a href="Home.jsp">Back To Home</a>
</div>






<form>
<%
ProductDAOImpl productDao=new ProductDAOImpl();
ResultSet rs=productDao.ShowCategory();

%>

<table align="center" border="3">

<th><h3>Category Name</h3></th>
<th><h3>Buy Product</h3></th>


<%while(rs.next()) {%>

<tr>

<td><%=rs.getString(1)%></td>

<td><button><a href="CategoryFilter.jsp?categoryname=<%=rs.getString(1)%>">Buy</a></button></button></button>

</td>
</tr>
<%} %>
</table>



</form>
</body>
</html>