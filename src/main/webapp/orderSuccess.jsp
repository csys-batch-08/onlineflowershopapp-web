<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<style>

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
body{
background-image:url('assets/home.jpg');
background-repeat:no-repeat;
background-size:cover;
}
h1{
margin-top:200px;
}

</style>

<meta charset="ISO-8859-1">
<title>Order success page</title>
</head>
<body>
<div class="topnav">
<a href="Home.jsp">Log Out</a>
</div>

<center><h1>Your Order is Placed Successfully!! Thank You!!</h1>

<h2><i>Your Payment Is Debited From Your Wallet</i></h2>




<%double totalprice=Double.parseDouble((session.getAttribute("totalPrice").toString())); %>
<h2><i>Your Total Amount is : <%=totalprice %></i></h2>

<%double wallet1=Double.parseDouble((session.getAttribute("wallbal").toString())); %>
<h2><i> Your  Wallet  Ballance Amount  is: <%=wallet1 %></i></h2>

 
 


<form action="RatingHere.jsp" metohd="post">
<button type="submit" name="button">Rating</button><br><br>

<a href="MyCart.jsp">My Order</a>


</form>
</center>


</body>
</html>