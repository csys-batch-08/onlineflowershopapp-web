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
  background-color:gray;
  color:white;
}


  


</style>




<meta charset="ISO-8859-1">
<title>Admin page</title>
</head>
<body>
<h3> Welcome Admin</h3>

<form>
<div class="topnav" >
  
  <a href="Home.jsp">LogOut</a>
  
  
  
   
</div>
</form>


<fieldset id="box">
<form action="ShowUser.jsp">
<button type="submit"id="button"><i>ShowUser</i> </button>
</form><br>

<form action="SalesHistory.jsp">
<button type="submit"id="button"><i>SalesHistory</i> </button>
</form><br>


<form action="UpdateProduct.jsp">
<button type="submit" id="button"><i>UpdateProduct</i></button>
</form><br>

<form action="AddProduct.jsp" >
<button type="submit" id="button"><i> AddProduct</i></button>
</form><br>

<form action="DeleteProduct.jsp">
<button type="submit" id="button"><i>DeleteProduct</i></button>
</form><br>


</fieldset>

</body>
</html>