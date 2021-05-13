<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Theater</title>
<style>
/*body style*/
body{
background-color: #ececec;
font-family: "Quicksand", sans-serif;
}

/*button style (general)*/
button{
width:80px;
height:30px;
border-radius:10px;
font-weight:bold;
}

/*navigation bar style*/
#nav{
height:6%;
width: 100%;
display: flex;
flex-direction: row;
justify-content: space-between;
}
#nav h3{
margin-top:10px;
margin-left:10px;
}
.Button{
color:#fff;
background-color:#323232;
}
.Button:hover{
background-color:#000;
color:#fff;
}

/*add button style*/
.add{
color:#000;
margin-top:20px;
background-color:#ffbd00;
border:2px solid #000;
box-shadow: 5px 10px 8px #a3a3a3;
}
.add:hover{
background-color:#ffd04c;
}

/*table's parent div style*/
.center {
  text-align: center;
}

/*table style*/
table{
border-radius: 20px;
padding: 20px 20px 20px 40px;
box-shadow: 5px 10px 8px #a3a3a3;
background-color: #fff;
}
td{
text-align:left;
}

/*table text-input style*/
.input{
text-align:center;
}
</style>
</head>
<body>
<%
	//checking if the user ID (uID) is present in the session or not.
	if(session.getAttribute("uID")==null)
	{
		response.sendRedirect("login.jsp");
	}
%>

<!-- navigation bar -->
<div id="nav">
<h3>Admin Panel</h3>
<form action="logout"><button type="submit" class="Button">Logout</button></form>
</div>

<!-- main container-->
<form action="addTheater" method="post">		<!-- addTheater points to AddTheater.java (servlet) -->
<div class="center">
	<table align="center" cellspacing="5" cellpadding="5" width=40%>
	<caption><h2>Add Theater</h2></caption>
	<col style="width:50%">
	<col style="width:50%">
	<tr>
	<td><h3>Theater Name</h3></td>
	<td class="input"><input type='text' name='theaterName' required><br></td>
	</tr>
	<tr>
	<td><h3>Contact</h3></td>
	<td class="input"><input type='number' name='theaterContact' required><br></td>
	</tr>
	<tr>
	<td><h3>Address</h3></td>
	<td class="input"><input type='text' name='address' required><br></td>
	</tr>
	</table>
	<button type="submit" class="add">Add</button>		<!-- on submit entered data send to the AddTheater.java (servlet) -->
</div>
</form>
</body>
</html>