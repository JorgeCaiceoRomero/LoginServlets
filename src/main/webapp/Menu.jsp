<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Menu</title>
</head>
<body>
	<h1>Menú</h1>
	<jsp:include page="Header.jsp" flush="false"/>
	<form action="AltaUsuario.jsp"method="post">	
		<input type="submit"  value="AltaUsuario"></input>
		
	</form>
	<form action="AltaRol.jsp"method="post">	
		<input type="submit"  value="AltaRol"></input>		
	</form>
	<form action="ListarRoles.jsp"method="post">	
		<input type="submit"  value="Lista de Roles"></input>
		
	</form>
	<form action="ListarUsuarios.jsp"method="post">	
		<input type="submit"  value="Lista de usuarios"></input>
		
	</form>
	<form action="ListarCategorias.jsp"method="post">	
		<input type="submit"  value="Lista de categorías"></input>
		
	</form>
	<form action="ListarProductos.jsp"method="post">	
		<input type="submit"  value="Lista de productos"></input>
		
	</form>
		
</body>
</html>