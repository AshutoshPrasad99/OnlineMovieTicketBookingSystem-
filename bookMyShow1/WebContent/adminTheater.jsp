<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.ArrayList"
    import="model.Theater"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin-Theater</title>
<style> 
.center {
  text-align: center;
}
th,td{
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
font-size:10px;
color:#006bff;
border:2px solid #006bff;
}
.updateB{
color:#37bfa0;
border:2px solid #37bfa0;
}
.deleteB{
color:#f70808;
border:2px solid #f70808;
}
.showB:hover{
background-color:#006bff;
color:#fff;
}
.updateB:hover{
background-color:#37bfa0;
color:#fff;
}
.deleteB:hover{
background-color:#f70808;
color:#fff;
}
.Button{
color:#fff;
margin-right:10px;
background-color:#323232;
}
.Button:hover{
background-color:#000;
color:#fff;
}
.add{
color:#000;
margin-bottom:50px;
background-color:#ffbd00;
border:2px solid #000;
}
.add:hover{
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
display:flex;
flex-direction:row;
margin-top:10px;
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
<form action="adminMovie"><button type="submit" class="Button">Movie</button></form>
<form action="adminUser"><button type="submit" class="Button">User</button></form>
<form action="logout"><button type="submit" class="Button">Logout</button></form>
</div>
</div>
<%
ArrayList<Theater> theater = (ArrayList<Theater>)request.getAttribute("theater");
%>
<div class="center">
<div class="caption"><h2>Theater Detail</h2></div>
<table align="center" cellspacing="5" cellpadding="5" border=1 frame=hsides rules=rows width=85%>
	<col style="width:50px">
	<col style="width:20%"> 
	<col style="width:20%">
	<col style="width:20%">
	<col style="width:20%">
	<col style="width:10%">
	<col style="width:5%">
	<col style="width:5%">
            <tr>
                <th>ID</th>
                <th>Theater</th>
                <th>Contact</th>
                <th>Address</th>
                <th>Total Seats</th>
            </tr>
            <%for(int i = 0; i < theater.size(); i++) {
                 Theater data =theater.get(i);
              %>
			
            <tr>
            		<td class="data"><%=data.getTheaterID()%></td>
            		<td><%=data.getTheaterName()%></td>
            		<td><%=data.getTheaterContact()%></td>
            		<td><%=data.getTheaterAddress()%></td>
            		<td>60</td>
            		<td>
            		<form action="adminShow">
            		<input type="hidden" name="theater" value="<%=data.getTheaterName()%>">
            		<input type="hidden" name="id" value="<%=data.getTheaterID()%>">
            		<input type="hidden" name="seat" value=60>
            		<button type="submit" class="showB">View Shows</button>
            		</form>
            		</td>
            		<td>
            		<a href="updateTheater.jsp?id=<%=data.getTheaterID()%>&name=<%=data.getTheaterName()%>&contact=<%=data.getTheaterContact()%>&address=<%=data.getTheaterAddress()%>">
            		<button type="button" class="updateB">Update</button>
            		</a>
            		</td>
            		<td>
            		<form action="deleteTheater">
						<input type="hidden" name="tid" value="<%=data.getTheaterID()%>">
						<button type="submit" class="deleteB">Delete</button>		<!-- on click DeleteTheater.java (servlet) will called and also theater ID send to it -->
					</form>
            		</td>
            </tr>
            <%
            }
            %>
        
    </table><br>
    <a href="addTheater.jsp"><button type="button" class="add">Add</button></a>
    </div>
</body>
</html>