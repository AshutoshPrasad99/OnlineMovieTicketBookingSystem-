<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.ArrayList"
    import="model.BookingDetail"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Booking Status</title>
<style>
.center {
  text-align: center;
}
th,td{
padding: 8px;
}
button{
width:80px;
height:30px;
border-radius:10px;
font-weight:bold;
}
.deleteB{
color:#f70808;
border:2px solid #f70808;
font-size:12px;
height:35px;
}
.deleteB:hover{
background-color:#f70808;
color:#fff;
}
.Button{
color:#fff;
background-color:#323232;
margin-right:20px;
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
.msg{
text-align:center;
}
table{
margin-top:15px;
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
<h2>Booking Detail</h2>
<div class="link">
<a href="home.jsp"><button type="submit" class="Button">Home</button></a>
<form action="logout"><button type="submit" class="Button">Logout</button></form>
</div>
</div>
<div>
<%
ArrayList<BookingDetail> booking = (ArrayList<BookingDetail>)request.getAttribute("bookingStatusData");

if(booking.size() == 0)
{
%>
<div class="msg">
<h2>Booking Status</h2><br>
<h3>You Didn't Booked Any Ticket Yet . . .</h3>
</div>
<%}
else
{
%>
<div class="center">
<table align="center" cellspacing="5" cellpadding="5" border=1 frame=hsides rules=rows width=85%>
	<caption><h2>Booking Status</h2></caption>
	<col style="width:5%">
	<col style="width:15%">
	<col style="width:5%">
	<col style="width:15%">
	<col style="width:15%">
	<col style="width:15%">
	<col style="width:16%">
	<col style="width:8%">
	<col style="width:5%">
	<col style="width:5%">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Age</th>
                <th>Movie</th>
                <th>Theater</th>
                <th>Address</th>
                <th>Date</th>
                <th>Seat</th>
                <th>Price</th>
            </tr>
        
            <%for(int i = 0; i < booking.size(); i++) {
                 BookingDetail data =booking.get(i);
              %>
			
            <tr>
            		<td><%=data.getBookingID()%></td>
            		<td><%=data.getCustomerName()%></td>
            		<td><%=data.getCustomerAge()%></td>
            		<td><%=data.getMovieName()%></td>
            		<td><%=data.getTheaterName()%></td>
            		<td><%=data.getTheaterAddress()%></td>
            		<td><%=data.getDate()%></td>
            		<td><%=data.getSeat()%></td>
            		<td><%=data.getPrice()%></td>
            		<td>
            		<form action="cancelTicket">
            			<input type="hidden" name="bid" value="<%=data.getBookingID()%>">
            			<button type="submit" class="deleteB">Cancel Booking</button>
            		</form>
<%--             		<a href="cancelTicket.jsp?id=<%=data.getBookingID()%>">
            		</a> --%>
            		</td>
            </tr>
            <%
            }
            %>
    </table>
    </div>
<%}%>
    </div>
</body>
</html>