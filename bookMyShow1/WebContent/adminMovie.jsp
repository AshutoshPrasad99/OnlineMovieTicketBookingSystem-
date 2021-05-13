<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="java.util.ArrayList"
	import="model.Movie"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin-Movie</title>
<style>
/*body style*/
body{
height: 100%;
widrh:100vw;
margin: 0%;
display:flex;
flex-direction:column;
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

/*navigation h3 style*/
#nav h3{
margin-top:10px;
margin-left:10px;
}

/*navigation button container style*/
.link{
padding-top:10px;
display: flex;
justify-content: space-evenly;
color: #000;
font-family: "Quicksand", sans-serif;
}

/*navigation button style*/
.Button{
color:#fff;
background-color:#323232;
}
.Button:hover{
background-color:#000;
color:#fff;
}

/*delete button style*/
.deleteB{
color:#f70808;
border:2px solid #f70808;
}
.deleteB:hover{
background-color:#f70808;
color:#fff;
}

/*add button style*/
.add{
color:#000;
margin-bottom:50px;
background-color:#ffbd00;
border:2px solid #000;
}
.add:hover{
background-color:#ffd04c;
}

/*main container style*/
.center {
  text-align: center;
}

/*table caption style*/
.caption{
width:100vw;
text-align:center;
background-color: #fff;
position:fixed;
top:8%;
}

/*table style*/
table{
margin-top:10%;
}
th,td{
padding: 8px;
text-align:left;
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
<div class="link">
<a href="adminHome.jsp"><button type="submit" class="Button">Home</button></a>
<form action="adminTheater"><button type="submit" class="Button">Theater</button></form>
<form action="adminUser"><button type="submit" class="Button">User</button></form>
<form action="logout"><button type="submit" class="Button">Logout</button></form>
</div>
</div>
<%
//retrieve movie data that comes from AdminMovie.java (servlet)
ArrayList<Movie> movie = (ArrayList<Movie>)request.getAttribute("movie");
%>

<!-- main container-->
<div class="center">
<div class="caption"><h2>Movie Detail</h2></div>		<!-- table caption-->
	<table align="center" cellspacing="5" cellpadding="5" border=1 frame=hsides rules=rows width=40%>
		<col style="width:10%">
		<col style="width:40%">
		<col style="width:10%">
			<tr>
				<th>ID</th>
				<th>Movie</th>
			</tr>
		<tbody>			<!-- displaying movie data-->
			<%for(int i = 0; i < movie.size(); i++) {
                Movie data = movie.get(i);
			%>
			<tr>
				<td><%=data.getMovieID()%></td>
				<td><%=data.getMovieName()%></td>
				<td>
					<form action="deleteMovie">
						<input type="hidden" name="mid" value="<%=data.getMovieID()%>">
						<button type="submit" class="deleteB">Delete</button>		<!-- on click DeleteMovie.java (servlet) will called and also movie ID send to it -->
					</form>
				</td>
			</tr>
			<%
            }
            %>
		</tbody>
	</table><br>
	<a href="addMovie.jsp"><button type="button" class="add">Add</button></a>		<!-- on click redirect to addMovie.jsp -->
</div>
</body>
</html>