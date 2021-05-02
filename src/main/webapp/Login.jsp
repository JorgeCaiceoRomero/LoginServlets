<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<%
	if(session!=null){
		session=request.getSession();
		session.invalidate();
	}	
	%>
	<form method="post" action="http://localhost:8080/Login/Login">
	Ingrese nombre de usuario:
	<input type="text" name="user" size="20"><br>
	Ingrese clave:
	<input type="password" name="pass" size="20"><br>
	<input type="submit" value="confirmar">
</form>
</body>
</html>