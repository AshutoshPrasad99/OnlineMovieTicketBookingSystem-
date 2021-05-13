<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alert</title>
<style>
.msg{
text-align: center;
}
</style>
</head>
<body>
<%boolean flag = (boolean)request.getAttribute("flag");
if(flag)
{
%>
<h3 class="msg">Password Changed.</h3>
<%}
else
{
%>
<h3 class="msg">Last Password is Incorrect.</h3>
<%
}
%>
</body>
</html>