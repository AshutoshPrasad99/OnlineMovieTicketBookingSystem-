<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Theater</title>
<style>
body{
background-color: #ececec;
font-family: "Quicksand", sans-serif;
}
td{
text-align:left;
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
margin-top:20px;
background-color:#37bfa0;
border:2px solid #000;
box-shadow: 5px 10px 8px #a3a3a3;
}
.add:hover{
background-color:#5ecbb3;
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
border-radius: 20px;
padding:20px 20px 20px 40px;
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
<form action="updateTheater" method="post">
	<div class="center">
		<input type='hidden' name='theaterID' value="<%=Integer.parseInt(request.getParameter("id"))%>">
		<table align="center" cellspacing="2" cellpadding="2" width=40%>
		<caption>
			<h2>Update Theater Details</h2>
		</caption>
		<col style="width:40%">
		<col style="width:60%">
		<tr>
		<td><h3>Theater Name:</h3></td>
		<td><input type='text' name='theaterName' value="<%=request.getParameter("name")%>" required></td>
		</tr>
		<tr>
		<td><h3>Contact:</h3></td>
		<td><input type='number' name='theaterContact' value="<%=Long.parseLong(request.getParameter("contact"))%>" required></td>
		</tr>
		<tr>
		<td><h3>Address:</h3></td>
		<td><input type='text' name='address' value="<%=request.getParameter("address")%>" required></td>
		</tr>
		</table><br>
		<button type="submit"  class="add")">Update</button>
		</div>
	</form>
</body>
</html>