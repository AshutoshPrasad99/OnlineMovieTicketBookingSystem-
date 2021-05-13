<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Booked</title>
<style>
body{
background-color: #ececec;
font-family: "Quicksand", sans-serif;
}
td{
text-align:center;
}
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
button{
width:80px;
height:30px;
border-radius:10px;
font-weight:bold;
}
.add{
color:#000;
height:35px;
margin-top:20px;
background-color:#349bff;
border:2px solid #000;
box-shadow: 5px 10px 8px #a3a3a3;
}
.add:hover{
background-color:#61b1ff;
}
.Button{
color:#fff;
background-color:#323232;
}
.Button:hover{
background-color:#000;
color:#fff;
}
table{
margin-top:100px;
border-radius: 20px;
padding:20px;
box-shadow: 5px 10px 8px #a3a3a3;
background-color: #fff;
}
.input{
text-align:center;
}
.center {
  text-align: center;
}
</style>
</head>
<body>
<div id="nav">
<h3>Admin Panel</h3>
<form action="logout"><button type="submit" class="Button">Logout</button></form>
</div>
<form action="userBookingStatus" method="get">
<div class="center">
	<table align="center" cellspacing="2" cellpadding="2" width=40%>
		<tr>
			<td><h3>- Ticket Booked Successfully -</h3></td>
		</tr>
	</table>
		<button type="submit" class="add">View Details</button>
</div>
</form>
</body>
</html>