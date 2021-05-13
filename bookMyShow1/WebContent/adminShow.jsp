<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.ArrayList"
    import="model.ShowsData"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin-Show</title>
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
margin-right:10px;
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
text-align:center;
padding: 8px;
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
<h3>Admin Panel -- [<%=request.getAttribute("theater")%>]</h3>
<div class="link">
<a href="adminHome.jsp"><button type="submit" class="Button">Home</button></a>
<form action="adminTheater"><button type="submit" class="Button">Theater</button></form>
<form action="adminMovie"><button type="submit" class="Button">Movie</button></form>
<form action="adminUser"><button type="submit" class="Button">User</button></form>
<form action="logout"><button type="submit" class="Button">Logout</button></form>
</div>
</div>
<%
//retrieve show data that comes from AdminShow.java (servlet)
ArrayList<ShowsData> shows = (ArrayList<ShowsData>)request.getAttribute("showsData");
ShowsData data = null;
%>

<!-- main container-->
<div class="center">
<div class="caption"><h2>Show Detail</h2></div>		<!-- table caption-->
<table align="center" cellspacing="5" cellpadding="5" border=1 frame=hsides rules=rows width=60%>
	<col style="width:10%">
	<col style="width:30%">
	<col style="width:25%">
	<col style="width:20%">
	<col style="width:10%">
	<col style="width:15%">
        <tr>
        <th>ID</th>
        <th>Movie</th>
         <th>Date</th>
         <th>Available Seats</th>
         <th>Price (Rs.)</th>
          </tr>
        
            <%for(int i = 0; i < shows.size(); i++) {			//displaying movie data
                 data =shows.get(i);
              %>
              
          <tr>
            <td><%=data.getShowID()%></td>
            <td><%=data.getMovieName()%></td>
            <td><%=data.getDate()%></td>
            <td><%=data.getAvailableSeat()%></td>
            <td><%=data.getPrice()%></td>
            <td>
            	<form action="deleteShow">
					<input type="hidden" name="sid" value="<%=data.getShowID()%>">
					<button type="submit" class="deleteB">Delete</button>		<!-- on click DeleteShow.java (servlet) will called and also show ID send to it -->
				</form>
            </td>
          </tr>
            <%
            }
            %>
        
    </table><br>
    <form action="selectMovie">
    <input type='hidden' name='theaterID' value="<%=data.getTheaterID()%>">
    <input type='hidden' name='seat' value="<%=(int)request.getAttribute("seat")%>">
    <button type="submit" class="add">Add</button>				<!-- on click SelectMovie.java (servlet) will called and theater ID and available seat number send to it -->
    </form>
    </div>
</body>
</html>