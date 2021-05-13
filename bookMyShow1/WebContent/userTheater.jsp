<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.ArrayList"
    import="model.TheaterList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Theater</title>
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
color:#006bff;
border:2px solid #006bff;
}
.showB:hover{
background-color:#006bff;
color:#fff;
}
.disabledB{
background-color:#ff4c97;
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
width: 30%;
height:100%;
}
img{
	width:39%;
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
 	margin-left:15%;
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
<!-- <form action="adminTheater"><button type="submit">Theater</button></form> -->
<h2>Select	Theater</h2>
<div class="link">
<a href="home.jsp"><button type="submit" class="Button">Home</button></a>
<form action="logout"><button type="submit" class="Button">Logout</button></form>
</div>
</div>
<%
ArrayList<TheaterList> theater = (ArrayList<TheaterList>)request.getAttribute("theater");
int mid = (int)request.getAttribute("mid");
%>
<div class="main">
<div class="image"><img id = img alt="" src="./image/theater.png"></div>
<div class="caption">
<table align="center" cellspacing="5" cellpadding="5" border=1 frame=hsides rules=rows width=70%>
		<col style="width:5%">
		<col style="width:17%">
		<col style="width:17%">
		<col style="width:17%">
		<col style="width:17%">
		<col style="width:10%">
		<col style="width:15%">
            <tr>
                <th>Theater</th>
                <th>Contact</th>
                <th>Address</th>
                <th>Date</th>
                <th>Available Seats</th>
                <th>Price</th>
            </tr>
            <%for(int i = 0; i < theater.size(); i++) {
                 TheaterList data =theater.get(i);
              %>

			<tr>
				<td class="table-data"><%=data.getTheaterName()%></td>
				<td class="table-data"><%=data.getContact()%></td>
				<td class="table-data"><%=data.getAddress()%></td>
				<td class="table-data"><%=data.getDate()%></td>
				<td class="table-data"><%=data.getSeats()%></td>
				<td class="table-data"><%=data.getPrice()%></td>
				<td>
					<form action="selectedShow">
						<input type="hidden" name="tid" value="<%=data.getTheaterID()%>">
						<input type="hidden" name="mid" value="<%=mid%>">
						<%if(data.getSeats() == 0){%>
							<button type="submit" class="disabledB" disabled>Full</button>
						<%}else{%>
							<button type="submit" class="showB">Select</button>
						<%}%>
					</form>
					
				</td>
			</tr>
			<%
				}
			%>
        
    </table><br>
    </div>
	</div>
</body>
</html>