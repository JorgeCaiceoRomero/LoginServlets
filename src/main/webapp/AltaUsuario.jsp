<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8   ">
<title>Alta Usuario</title>
</head>
<body>
    <form method="post" action="http://localhost:8080/Login/AltaUsuario">
    <jsp:include page="Header.jsp" flush="false"/>
        <h1>Alta Usuario</h1>  
        <label>Id_Rol: </label>
        <input type="text" name="idrol" id="idrol"><br><br>
        <label>Email: </label>
        <input type="text" name="email" id="email"><br><br>
        <label>Clave: </label>
        <input type="text" name="clave" id="clave"><br><br>
        <label>Nombre: </label>
        <input type="text" name="nombre" id="nombre"><br><br>
        <label>Apellido1: </label>
        <input type="text" name="apellido1" id="apellido1"><br><br>
        <label>Apellido2: </label>
        <input type="text" name="apellido2" id="apellido2"><br><br>
        <label>Direcci�n: </label>
        <input type="text" name="direccion" id="direccion"><br><br>
        <label>Localidad: </label>
        <input type="text" name="localidad" id="localidad"><br><br>
        <label>Provincia: </label>
        <input type="text" name="provincia" id="provincia"><br><br>
        <label>Tel�fono: </label>
        <input type="text" name="telefono" id="telefono"><br><br>
        <label>DNI: </label>
        <input type="text" name="dni" id="dni"><br><br>

        <input type="submit" value="Alta"> 
    </form>
</body>
</html>