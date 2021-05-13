<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin-Home</title>
<style>
/*body style*/
body{
background-color: #ececec;
font-family: "Quicksand", sans-serif;
}

/*navigation bar style*/
#nav{
height:6%;
width: 100%;
display: flex;
flex-direction: row;
justify-content: left;
}
#nav h3{
margin-top:10px;
margin-left:10px;
}

/*button style*/
button{
width:100px;
height:40px;
border-radius:10px;
font-weight:bold;
color:#000;
background-color:#ffbd00;
border:2px solid #000;
}
button:hover{
background-color:#ffd04c;
}
.logout{
background-color:#ff4c4c;
}
.logout:hover{
background-color:#ff1919;
color: #fff;
}

/*table style*/
table{
border-radius: 20px;
margin-top: 30px;
padding-bottom: 20px;
box-shadow: 5px 10px 8px #a3a3a3;
background-color: #fff;
}
td{
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
</div>

<!-- main card container-->
<table align="center" cellspacing="5" cellpadding="5" width=40%>
	<tr colspan=2><td><h2>-Welcome to Admin Page-</h2></td></tr>
	<tr><td><form action="adminTheater"><button type="submit">Theater</button></form></td></tr>		<!-- on submit AdminTheater.java (servlet) will called-->
	<tr><td>
		<form action="adminMovie">
			<%HttpSession session1 = request.getSession();		//creating HttpSession
			session1.setAttribute("person", "admin"); %>		<!-- storing value "admin" in the session1 labeled as person-->
			<button type="submit">Movie</button>		<!-- on submit AdminMovie.java (servlet) will called-->
		</form>
	</td></tr>
	<tr><td><form action="adminUser"><button type="submit">User</button></form></td></tr>		<!-- on submit AdminUser.java (servlet) will called-->
	<tr><td><form action="logout"><button type="submit" class="logout">Logout</button></form></td></tr>		<!-- on submit Logout.java (servlet) will called-->
</table>
</body>
</html>