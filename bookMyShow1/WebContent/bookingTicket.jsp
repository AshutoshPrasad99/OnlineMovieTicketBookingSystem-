<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Booking</title>
<style>
th,td{
text-align:Center;
padding: 8px;
z-index:-1;
}
button{
width:80px;
height:30px;
border-radius:10px;
font-weight:bold;
}
.showB{
color:#000;
background-color:#b67ea1;
border:2px solid #000;
margin-top:30px;
margin-left:-50px;
margin-bottom: 50px;
}
.showB:hover{
background-color:#c69ab6;
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
width: 30%;
height:100%;
}
img{
	width:20%;
	heigth: auto;
	position: fixed;
	left:150px;
	}
 	.caption{ 
 	flex:1;
 	display: flex;
 	flex-direction:column;  
 	text-align:center; 
 	}
 	table{
 	margin-left:15%;
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
<h2>Customer Detail</h2>
<div class="link">
<a href="home.jsp"><button type="submit" class="Button">Home</button></a>
<form action="logout"><button type="submit" class="Button">Logout</button></form>
</div>
</div>
<div class="main">
<div class="image"><img id = img alt="" src="./image/people.png"></div>
<div class="caption">
<%
HttpSession seatData = request.getSession();
String[] seats = (String[])seatData.getAttribute("seat");
int sid = (int)seatData.getAttribute("sid");
%>
<form action="book">
	<input type="hidden" name="sid" value="<%=sid%>">
	<table align="center" width=60%>
		<col style="width:50%">
		<col style="width:50%">
	<%for(int i = 0; i<seats.length; i++){ %>
	<tr>
	<td><h3>Seat No.  <%=seats[i]%></h3></td>
	<td>Name : </td>
	<td><input type="text" name="name<%=i+1%>" required></td>
	</tr>
	<tr>
	<td></td>
	<td>Age : </td>
	<td><input type="number" name="age<%=i+1%>" required></td>
	</tr>
	<%} %>
	</table>
	<button type="submit" class="showB">Book</button>
</form>
</div>
</div>
</body>
</html>