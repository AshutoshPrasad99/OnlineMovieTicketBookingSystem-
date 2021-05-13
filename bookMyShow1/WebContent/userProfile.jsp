<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="model.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Profile</title>
<style>
th,td{
text-align: left;
padding: 8px;
z-index:-1;
}
button{
width:80px;
height:30px;
border-radius:10px;
font-weight:bold;
}
.changePass{
color:#00;
height:35px;
font-size:12px;
background-color:#37bfa0;
border:2px solid #000;
}
.changePass:hover{
background-color:#5ecbb3;
}
.Button{
margin-right:10px;
color:#fff;
background-color:#323232;
}
.Button:hover{
background-color:#000;
color:#fff;
}
.update{
color:#000;
height:35px;
background-color:#ffbd00;
border:2px solid #000;
}
.update:hover{
background-color:#ffd04c;
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
height:7%;
width: 100%;
display: flex;
flex-direction: row;
background-color: #fff;
justify-content: space-between;
padding-top:10px;
padding-bottom:10px;
color: #000;
font-family: "Quicksand", sans-serif;
position:fixed;
}
#nav h3{
margin-top:10px;
margin-left:10px;
}
.link{
display:flex;
flex-direction:row;
}
.main{
margin-top:5%;
display: flex;
flex-direction: row;
justify-content: space-evenly;
}
.image{
flex:0.5;
width: 40%;
height:100%;
}
img{
	width:49%;
	heigth: auto;
	position: fixed;
	top: 150px;
	}
 	.caption{ 
 	flex:1;
 	display: flex;
 	flex-direction:column;  
 	text-align:center; 
 	}
 	table{
 	margin-left:25%;
 	margin-top:50px;
 	padding-top:20px;
 	}
 	h2{
 	margin-top:10px;
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
<h3>User : <%=session.getAttribute("uname") %></h3>
<h2>Profile</h2>
<div class="link">
<a href="home.jsp"><button type="submit" class="Button">Home</button></a>
<form action="logout"><button type="submit" class="Button">Logout</button></form>
</div>
</div>
<%User user = (User) request.getAttribute("userData");%>
<div class="main">
<div class="image"><img id = img alt="" src="./image/profile.png"></div>
<div class="caption">
	<table align="center" cellspacing="5" cellpadding="5" border=1 frame=hsides rules=rows width=60%>
		<col style="width:50%">
		<col style="width:50%">
			<tr>
				<td><h3>Name</h3></td>
				<td><%=user.getName()%></td>
			</tr>
			<tr>
				<td><h3>Contact</h3></td>
				<td><%=user.getContact()%></td>
			</tr>
			<tr>
				<td><h3>Email</h3></td>
				<td><%=user.getEmail()%></td>
			</tr>
			<tr>
				<td><a
					href="updateProfile.jsp?name=<%=user.getName()%>&contact=<%=user.getContact()%>&email=<%=user.getEmail()%>">
						<button type="button" class="update">Update</button>
				</a></td>
				<td><a href="changePassword.jsp">
						<button type="button" class="changePass">Change Password</button>
				</a></td>
			</tr>
		</table>
		</div>
	</div>
</body>
</html>