<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Profile</title>
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
margin-top:20px;
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
<div id="nav">
<h3>User : <%=session.getAttribute("uname") %></h3>
<h2>Update Profile</h2>
<div class="link">
<a href="home.jsp"><button type="submit" class="Button">Home</button></a>
<form action="logout"><button type="submit" class="Button">Logout</button></form>
</div>
</div>
<div class="main">
<div class="image"><img id = img alt="" src="./image/profile.png"></div>
<div class="caption">
	<form action="updateProfile" method="post">
		<table align="center" cellspacing="5" cellpadding="5" border=1 frame=hsides rules=rows width=60%>
		<col style="width:50%">
		<col style="width:50%">
			<tr>
			<td><h3>Name:</h3></td>
			<td><input type='text' name='name' value="<%=request.getParameter("name")%>" required></td>
			</tr>
			
			<tr>
			<td><h3>Contact:</h3></td>
			<td><input type='number' name='contact' min=6000000000 oninvalid="this.setCustomValidity('Invalid Contact Number...')"
  				oninput="this.setCustomValidity('')" value="<%=Long.parseLong(request.getParameter("contact"))%>" required>
  			</td>
			</tr>
			
			<tr>
			<td><h3>Email:</h3></td>
			<td><input type='text' name='email' value="<%=request.getParameter("email")%>" required></td>
			</tr>
		</table>
		<button type="submit" class="update">Update</button>
	</form>
</div>
</div>
</body>
</html>