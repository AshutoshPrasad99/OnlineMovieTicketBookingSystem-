<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
	import="java.util.ArrayList"
	import="model.Movie"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Show</title>
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
padding:20px 20px 20px 40px;
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

<%
//retrieve data that was coming from SelectMovie.java (Servlet)
ArrayList<Movie> movie = (ArrayList<Movie>)request.getAttribute("selectMovie");
int theaterID = (int)request.getAttribute("theaterID");
%>

<!-- main container-->
<form action="addShow" method="post">		<!-- addShow points to AddShow.java (servlet) -->
	<div class="center">
 		<input type='hidden' name='theaterID' value="<%=theaterID%>">
 		<input type='hidden' name='seat' value="<%=(int)request.getAttribute("seat")%>">
 		<table align="center" cellspacing="2" cellpadding="2" width=40%>
 			<caption><h2>Add Show</h2></caption>
 			<col style="width:40%">
			<col style="width:60%">
 			<tr>
 				<td><label><h3>Select Movie:</h3></label></td>
					<td><select name="movieID">
					<%for (int i = 0; i < movie.size(); i++) {
						Movie data = movie.get(i);
					%>
						<option value="<%=data.getMovieID()%>"><%=data.getMovieName()%></option>
					<%
					}
					%>
				</select></td>
 			</tr>
 			<tr>
				<td><h3>Date:</h3></td>
				<td><input type="datetime-local" name="date" required></td>
			</tr>
			<tr>
				<td><h3>Price:</h3></td>
				<td><input type='number' min=0 name='price' required></td>
			</tr>
		</table>
		<button type="submit" class="add">Add</button>		<!-- on submit selected movie name and entered data send to the AddShow.java (servlet) -->
	</div>
</form>
</body>
</html>