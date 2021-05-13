<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Seat</title>
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
.Button{
margin-right:10px;
color:#fff;
background-color:#323232;
}
.Button:hover{
background-color:#000;
color:#fff;
}
.add{
color:#000;
margin-top:5%;
background-color:#4c97ff;
border:2px solid #000;
}
.add:hover{
background-color:#7fb5ff;
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
height:45px;
width: 100%;
display: flex;
flex-direction: row;
background-color: #fff;
justify-content: space-between;
padding-top:10px;
padding-bottom:10px;
color: #000;
font-family: "Quicksand", sans-serif;
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
display: flex;
flex-direction: column;
justify-content: center;
align-items: center;
}
h2{
margin-top:10px;
}
.screen{
text-align: center;
width:65vw;
height:30px;
background-color:#c1dfff;
border-radius:10px;
display:flex;
flex-direction:row;
justify-content:center;
}
h1{
margin:0px 20px 0px 20px;
font-size:25px;
}
ol {
  list-style :none;
  padding: 0;
  margin: 0;
}
.seats {
  display: flex;
  flex-direction: row;
  flex-wrap: nowrap;
  justify-content: flex-start;  
}
.seat{
padding:5px;
margin: 3px 8px 3px 8px;
border-radius: 10px;
}
.seat:nth-child(6){
margin-right:100px;
}
.seatArray{
margin-top:15%;
}
input{
position:absolute;
opacity:0%; 
}
label{
display: block;
position: relative;    
width: 40px;
height:30px; 
text-align:center;
font-size: 14px;
font-weight: bold;
line-height: 1.5rem;
padding: 4px 0;
background-color: #ffbd00;
border-radius: 5px;
}
form{
text-align: center;
}
#fixedTable{
position:fixed;
top:70px;
left:10px;
}
td{
padding:0;
}
.colorIndicator{
border-radius:10px;
width:20px;
}
#booked{
background-color: #ff6666;
}
#available{
background-color: #ffbd00;
}
#selected{
background-color: #32bda2;
}
</style>
</head>
<body>
<div id="nav">
<h3>User : <%=session.getAttribute("uname") %></h3>
<h2>Select Seat/s</h2>
<div class="link">
<a href="home.jsp"><button type="submit" class="Button">Home</button></a>
<form action="logout"><button type="submit" class="Button">Logout</button></form>
</div>
</div>

<div class="main">
<%int sid = (int)request.getAttribute("sid");
ArrayList<String> seats = (ArrayList<String>)request.getAttribute("seats");
for(int i = 0; i < seats.size(); i++)
{
	System.out.println("Seat "+i+" = "+seats.get(i));
}%>
<div class="screen">
	<h1>S </h1>
	<h1>C</h1>
	<h1>R</h1>
	<h1>E</h1>
	<h1>E</h1>
	<h1>N</h1>
</div>
<div id="fixedTable">
	<table>
	<tr>
		<td class="colorIndicator" id="booked"> </td>
		<td>Booked</td>
	</tr>
	<tr>
		<td class="colorIndicator" id="available"></td>
		<td>Available</td>
	</tr>
	<tr>
		<td class="colorIndicator" id="selected"></td>
		<td>Selected</td>
	</tr>
	</table>
</div>
<form>
<div class="seatArray">
	<ol>
		<li class="row">
			<ol class="seats">
				<li class="seat">
					<label for="1">1A<input type="checkbox" id="1" name="type" value="1A"></label>
				</li>
				<li class="seat">
					<label for="2">1B<input type="checkbox" id="2" name="type" value="1B"></label>
				</li>
				<li class="seat">
					<label for="3">1C<input type="checkbox" id="3" name="type" value="1C"></label>
				</li>
				<li class="seat">
					<label for="4">1D<input type="checkbox" id="4" name="type" value="1D"></label>
				</li>
				<li class="seat">
					<label for="5">1E<input type="checkbox" id="5" name="type" value="1E"></label>
				</li>
				<li class="seat">
					<label for="6">1F<input type="checkbox" id="6" name="type" value="1F"></label>
				</li>
				<li class="seat">
					<label for="7">1G<input type="checkbox" id="7" name="type" value="1G"></label>
				</li>
				<li class="seat">
					<label for="8">1H<input type="checkbox" id="8" name="type" value="1H"></label>
				</li>
				<li class="seat">
					<label for="9">1I<input type="checkbox" id="9" name="type" value="1I"></label>
				</li>
				<li class="seat">
					<label for="10">1J<input type="checkbox" id="10" name="type" value="1J"></label>
				</li>
				<li class="seat">
					<label for="11">1K<input type="checkbox" id="11" name="type" value="1K"></label>
				</li>
				<li class="seat">
					<label for="12">1L<input type="checkbox" id="12" name="type" value="1L"></label>
				</li>
			</ol>
		</li>
		<li class="row">
			<ol class="seats">
				<li class="seat">
					<label for="13">2A<input type="checkbox" id="13" name="type" value="2A"></label>
				</li>
				<li class="seat">
					<label for="14">2B<input type="checkbox" id="14" name="type" value="2B"></label>
				</li>
				<li class="seat">
					<label for="15">2C<input type="checkbox" id="15" name="type" value="2C"></label>
				</li>
				<li class="seat">
					<label for="16">2D<input type="checkbox" id="16" name="type" value="2D"></label>
				</li>
				<li class="seat">
					<label for="17">2E<input type="checkbox" id="17" name="type" value="2E"></label>
				</li>
				<li class="seat">
					<label for="18">2F<input type="checkbox" id="18" name="type" value="2F"></label>
				</li>
				<li class="seat">
					<label for="19">2G<input type="checkbox" id="19" name="type" value="2G"></label>
				</li>
				<li class="seat">
					<label for="20">2H<input type="checkbox" id="20" name="type" value="2H"></label>
				</li>
				<li class="seat">
					<label for="21">2I<input type="checkbox" id="21" name="type" value="2I"></label>
				</li>
				<li class="seat">
					<label for="22">2J<input type="checkbox" id="22" name="type" value="2J"></label>
				</li>
				<li class="seat">
					<label for="23">2K<input type="checkbox" id="23" name="type" value="2K"></label>
				</li>
				<li class="seat">
					<label for="24">2L<input type="checkbox" id="24" name="type" value="2L"></label>
				</li>
			</ol>
		</li>
		<li class="row">
			<ol class="seats">
				<li class="seat">
					<label for="25">3A<input type="checkbox" id="25" name="type" value="3A"></label>
				</li>
				<li class="seat">
					<label for="26">3B<input type="checkbox" id="26" name="type" value="3B"></label>
				</li>
				<li class="seat">
					<label for="27">3C<input type="checkbox" id="27" name="type" value="3C"></label>
				</li>
				<li class="seat">
					<label for="28">3D<input type="checkbox" id="28" name="type" value="3D"></label>
				</li>
				<li class="seat">
					<label for="29">3E<input type="checkbox" id="29" name="type" value="3E"></label>
				</li>
				<li class="seat">
					<label for="30">3F<input type="checkbox" id="30" name="type" value="3F"></label>
				</li>
				<li class="seat">
					<label for="31">3G<input type="checkbox" id="31" name="type" value="3G"></label>
				</li>
				<li class="seat">
					<label for="32">3H<input type="checkbox" id="32" name="type" value="3H"></label>
				</li>
				<li class="seat">
					<label for="33">3I<input type="checkbox" id="33" name="type" value="3I"></label>
				</li>
				<li class="seat">
					<label for="34">3J<input type="checkbox" id="34" name="type" value="3J"></label>
				</li>
				<li class="seat">
					<label for="35">3K<input type="checkbox" id="35" name="type" value="3K"></label>
				</li>
				<li class="seat">
					<label for="36">3L<input type="checkbox" id="36" name="type" value="3L"></label>
				</li>
			</ol>
		</li>
		<li class="row">
			<ol class="seats">
				<li class="seat">
					<label for="37">4A<input type="checkbox" id="37" name="type" value="4A"></label>
				</li>
				<li class="seat">
					<label for="38">4B<input type="checkbox" id="38" name="type" value="4B"></label>
				</li>
				<li class="seat">
					<label for="39">4C<input type="checkbox" id="39" name="type" value="4C"></label>
				</li>
				<li class="seat">
					<label for="40">4D<input type="checkbox" id="40" name="type" value="4D"></label>
				</li>
				<li class="seat">
					<label for="41">4E<input type="checkbox" id="41" name="type" value="4E"></label>
				</li>
				<li class="seat">
					<label for="42">4F<input type="checkbox" id="42" name="type" value="4F"></label>
				</li>
				<li class="seat">
					<label for="43">4G<input type="checkbox" id="43" name="type" value="4G"></label>
				</li>
				<li class="seat">
					<label for="44">4H<input type="checkbox" id="44" name="type" value="4H"></label>
				</li>
				<li class="seat">
					<label for="45">4I<input type="checkbox" id="45" name="type" value="4I"></label>
				</li>
				<li class="seat">
					<label for="46">4J<input type="checkbox" id="46" name="type" value="4J"></label>
				</li>
				<li class="seat">
					<label for="47">4K<input type="checkbox" id="47" name="type" value="4K"></label>
				</li>
				<li class="seat">
					<label for="48">4L<input type="checkbox" id="48" name="type" value="4L"></label>
				</li>
			</ol>
		</li>
		<li class="row">
			<ol class="seats">
				<li class="seat">
					<label for="49">5A<input type="checkbox" id="49" name="type" value="5A"></label>
				</li>
				<li class="seat">
					<label for="50">5B<input type="checkbox" id="50" name="type" value="5B"></label>
				</li>
				<li class="seat">
					<label for="51">5C<input type="checkbox" id="51" name="type" value="5C"></label>
				</li>
				<li class="seat">
					<label for="52">5D<input type="checkbox" id="52" name="type" value="5D"></label>
				</li>
				<li class="seat">
					<label for="53">5E<input type="checkbox" id="53" name="type" value="5E"></label>
				</li>
				<li class="seat">
					<label for="54">5F<input type="checkbox" id="54" name="type" value="5F"></label>
				</li>
				<li class="seat">
					<label for="55">5G<input type="checkbox" id="55" name="type" value="5G"></label>
				</li>
				<li class="seat">
					<label for="56">5H<input type="checkbox" id="56" name="type" value="5H"></label>
				</li>
				<li class="seat">
					<label for="57">5I<input type="checkbox" id="57" name="type" value="5I"></label>
				</li>
				<li class="seat">
					<label for="58">5J<input type="checkbox" id="58" name="type" value="5J"></label>
				</li>
				<li class="seat">
					<label for="59">5K<input type="checkbox" id="59" name="type" value="5K"></label>
				</li>
				<li class="seat">
					<label for="60">5L<input type="checkbox" id="60" name="type" value="5L"></label>
				</li>
			</ol>
		</li>
	</ol>
</div>
<button type="button" class="add">Next</button>
</form>
</div>
</body>
<script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>
<script> 
var seatArr = new Array();
var seatData = new Array();
<%for(int i = 0; i < seats.size(); i++){%>
	seatData[<%=i%>] = '<%=seats.get(i)%>';
<%}%>
 $(document).ready(function(){
	 var temp = 0;
	 for(var i = 1; i <= 60; i++)
	 {
		 for(var j = 0; j < seatData.length; j++)
		 {
			 if($("#"+i).val() === seatData[j])
			 {
				 $("#"+i).parent().css("background-color","#ff6666");
	 	 		 $("#"+i).prop('disabled',true);
	 	 		 temp++;
			 }
		 }
		 if(temp === seatData.length)
			 break;
	 }
	 
	 $("input[type='checkbox']").change(function(){
 		if($(this).is(":checked"))
 		{
 			$(this).parent().css("background-color","#32bda2");
 			seatArr.push($(this).val());
 		}
 		else
 		{
 			$(this).parent().css("background-color","#ffbd00");
 			seatArr.splice(seatArr.indexOf($(this).val()),1);
 		}
 	});
 	
 	$(".add").click(function(event){
 		console.log(seatArr);
 		$.ajax({
 			url:"custNumber",
 			type:"POST",
 			dataType:'json',
 			data:{seatArr:seatArr, sid:<%=sid%>},
 			success:function(data){
 				window.location = data.url; },
 			error:function(errorThrown){
 				console.log("Error....");
 			}
 		});
 	});
 })
 </script>
</html>