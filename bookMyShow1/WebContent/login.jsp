<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<style>
*{
margin: 0%;
padding: 0px;
font-size: 20px;
}
a{
  text-decoration: none;
  opacity: 0.85;
  color: #fff;
}
a:hover{
  opacity: 1;
  font-weight: bold;
}
	body{
	height: 100vh;
	widrh:100vw;
	margin: 0%;
	display:flex;
	flex-direction:column;
	justify-content:center;
	font-family: "Quicksand", sans-serif;
	background-color: #deae4f;
	overflow:hidden;
	}
	#parent{
	width:80%;
	height:80%;
	margin: 20px 100px 20px 100px;
	padding: 20px;
	display:flex;
	border-radius: 15px;
	flex-direction: row;
	justify-content:center;
	background-color:#fff;
	box-shadow: 5px 10px 8px #bc8f3b;
	}
	.image{
	flex:1;
	margin-right: 15px;
	}
	img{
	width:100%;
	heigth: auto;
	border-radius: 10px;
	}
	.login{
	flex:2.2;
	display: flex;
	flex-direction:column;
	justify-content:center;
	text-align:center;
	}
	h1{
	flex:1;
	}
	form{
	margin-left:100px;
	margin-right:100px;
	flex:4;
	display: flex;
	flex-direction: column;
	align-content:center;
	width: 70%;
	}
	input{
	padding: 12px 20px;
  	margin: 8px 0;
  	border:1px solid #000;
  	border-radius: 15px;
  	box-sizing: border-box;
  	text-align:center;
  	outline: none;
	}
	button{
	width: 70%;
	height: 50px;
	margin-left: 70px;
	margin-right: 70px;
	padding: 10px;
	border:0px;
  	border-radius: 15px;
  	font-size: 25px;
  	color: #303030;
  	outline: none;
  	box-shadow: 2px 6px 8px #888888;
  	background-color: #91c1e1;
	}
	button:hover{
	width: 71%;
	height: 55px;
	color: #000;
	outline: none;
	font-weight: bold;
	box-shadow: 5px 10px 8px #888888;
	}
#nav{
height:6%;
width: 100%;
display: flex;
flex-direction: row;
justify-content: flex-end;
}
.link{
width: 30vw;
padding-top:20px;
padding-right:10px;
display: flex;
justify-content: space-evenly;
color: #000;
font-family: "Quicksand", sans-serif;
}
#parent h1{
font-size:40px;
}
</style>
</head>
<body>
<div id="nav">
	<div class="link">
		<a href="login.jsp">Login</a>
		<a href="signup.jsp">Sign Up</a>
		<a href="#">About Us</a>
	</div>
</div>
<div id=parent>
	<div class = image>
	<img src="./image/login.png">
	</div>
	<div class = login>
	<h1>Login</h1><br>
	<form action='login' method='post'>
		<h3>User name:</h3>
		<input type='text' name='username' placeholder="Enter Username"><br>
		<h3>Password:</h3>
		<input type='password' name='pass' placeholder="Enter Password"><br> 
		<button type="submit">Login</button>
	</form>

	</div>
</div>
</body>
</html>