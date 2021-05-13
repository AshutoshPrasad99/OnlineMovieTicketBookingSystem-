<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="java.util.ArrayList"
	import="model.Movie"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Movie</title>
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
.showB{
color:#006bff;
border:2px solid #006bff;
}
.showB:hover{
background-color:#006bff;
color:#fff;
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
margin:20px 25% 15%;
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
<h2>Select Movie</h2>
<div class="link">
<a href="home.jsp"><button type="submit" class="Button">Home</button></a>
<form action="logout"><button type="submit" class="Button">Logout</button></form>
</div>
</div>
<%
ArrayList<Movie> movie = (ArrayList<Movie>)request.getAttribute("movie");
%>
<div class="main">
<div class="image"><img id = img alt="" src="./image/movie.png"></div>
<div class="caption">
	<table align="center" cellspacing="5" cellpadding="5" border=1 frame=hsides rules=rows width=60%>
		<col style="width:40%">
		<col style="width:10%">
		<tbody>
			<%for(int i = 0; i < movie.size(); i++) {
                Movie data = movie.get(i);
			%>
			<tr>
				<td><%=data.getMovieName()%></td>
				<td class="center"><form action="userTheater">
				<input type="hidden" name="mid" value="<%=data.getMovieID()%>">
				<button type="submit" class="showB">Select</button></form></td>
			</tr>
			<%
            }
            %>
		</tbody>
	</table>
	</div>
	</div>
</body>
</html>