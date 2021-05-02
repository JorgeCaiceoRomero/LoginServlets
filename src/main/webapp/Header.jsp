<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cabecera</title>
</head>
<body>
	<h3>Usuario: ${sessionScope.nombreUsuario}, Rol: ${sessionScope.rol}, Inicio de sesión: ${sessionScope.fecha}	
	</h3>
	<form action="javascript:history.back()"> <input type="submit" value="&lt;-"/></form>
	<form action="Login.jsp"method="post">	
		<input type="submit"  value="Cerrar Sesión"></input>
		
	</form>
	<br/><br/>
</body>
</html>