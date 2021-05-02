<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alta rol</title>
</head>
<body>
    <form method="post" action="http://localhost:8080/Login/AltaRol">
    <jsp:include page="Header.jsp" flush="false"/>
        <h1>Alta Rol</h1>
        <label>Rol: </label>
        <input type="text" name="rol" id="rol"><br><br>
        <input type="submit" value="Alta">
    </form>
</body>
</html>