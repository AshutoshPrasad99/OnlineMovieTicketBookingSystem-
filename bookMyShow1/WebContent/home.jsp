<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
<style>
	body{
	display: flex;
	flex-direction: row;
	margin: 0px 0px;
	padding: 20px 20px;
	background-color: #ececec;
	}
	.image{
	flex:1;
	width:44%;
	margin-right: 15px;
	}
	#img{
	width:100%;
	heigth: auto;
	border-radius: 10px;
	box-shadow: 5px 10px 8px #a3a3a3;
	}
	.option{
	flex:1.2;
	display:flex;
/* 	flex-wrap: wrap; */
 	flex-direction: column;
	justify-content: center;
	}
	button{
	width: 70%;
	height: 50px;
	margin-left: 15px;
	padding: 10px;
	border:0px;
  	border-radius: 15px;
  	font-size: 25px;
  	color: #303030;
  	background-color:#fff;
  	box-shadow: 2px 6px 8px #a3a3a3;
	}
	button:hover{
	width: 71%;
	height: 55px;
	color: #000;
	outline: none;
	font-weight: bold;
	box-shadow: 5px 10px 8px #a3a3a3;
	}
	.icon{
	padding-top:10px;
	width: 50px;
	height: 50px;
	}
	form{
	margin:10px
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
<div class = image>
	<img id = img alt="" src="./image/home.png">
</div>
<div class = option>
	<form action="adminMovie">
	<%HttpSession session1 = request.getSession();
	session.setAttribute("person", "user"); %>
	<img class = icon src="./icon/ticket.png">
	<button type="submit">Book Movie Ticket</button>
	</form>
	<form action="userBookingStatus">
	<img class = icon src="./icon/booking.png">
	<button type="submit">Booking Status</button>
	</form>
	<form action="userProfile">
	<img class = icon src = "./icon/profile.png">
	<button type="submit">Profile</button>
	</form>
	<form action="logout">
	<img class = icon src="./icon/logout.png">
	<button type="submit">Logout</button>
	</form>
</div>
</body>
</html>