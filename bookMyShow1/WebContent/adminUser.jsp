<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.ArrayList"
	import="model.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin-User</title>
<style>
.center {
  text-align: center;
}
th,td{
padding: 8px;
text-align:center;
}
button{
width:80px;
height:30px;
border-radius:10px;
font-weight:bold;
}
.deleteB{
color:#f70808;
border:2px solid #f70808;
}
.deleteB:hover{
background-color:#f70808;
color:#fff;
}
.Button{
color:#fff;
background-color:#323232;
}
.Button:hover{
background-color:#000;
color:#fff;
}
body{
	height: 100%;
	widrh:100vw;
	margin: 0%;
	display:flex;
	flex-direction:column;
	font-family: "Quicksand", sans-serif;
	}
	#nav{
height:8%;
width: 100%;
display: flex;
flex-direction: row;
justify-content: space-between;
background-color: #fff;
color: #000;
position:fixed;
z-indez:0;
}
.link{
padding-top:10px;
display: flex;
justify-content: space-evenly;
color: #000;
font-family: "Quicksand", sans-serif;
}
#nav h3{
margin-top:10px;
margin-left:10px;
}
.caption{
width:100vw;
text-align:center;
background-color: #fff;
position:fixed;
top:8%;
}
table{
margin-top:10%;
}
</style>
</head>
<body>
<%
	response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");	//http 1.1
	response.setHeader("pragma","no-cache");	//http 1.0
	response.setHeader("Expires","0");		//proxies

	if(session.getAttribute("uID")==null)
	{
		response.sendRedirect("login.jsp");
	}
%>
<div id="nav">
<h3>Admin Panel</h3>
<div class="link">
<a href="adminHome.jsp"><button type="submit" class="Button">Home</button></a>
<form action="adminTheater"><button type="submit" class="Button">Theater</button></form>
<form action="adminMovie"><button type="submit" class="Button">Movie</button></form>
<form action="logout"><button type="submit" class="Button">Logout</button></form>
</div>
</div>
<%
ArrayList<User> user = (ArrayList<User>)request.getAttribute("user");
%>
<div class="center">
<div class="caption"><h2>User Detail</h2></div>
	<table align="center" cellspacing="5" cellpadding="5" border=1 frame=hsides rules=rows width=50%>
		<col style="width:10%">
		<col style="width:25%">
		<col style="width:25%">
		<col style="width:40%">
			<tr>
				<th>ID</th>
				<th>User Name</th>
				<th>Contact</th>
				<th>Email</th>
			</tr>
		<tbody>
			<%for(int i = 0; i < user.size(); i++) {
                User data = user.get(i);
			%>
			<tr>
				<td><%=data.getUserID()%></td>
				<td><%=data.getName()%></td>
				<td><%=data.getContact()%></td>
				<td><%=data.getEmail()%></td>
			</tr>
			<%
            }
            %>
		</tbody>
	</table>
</div>
</body>
</html>