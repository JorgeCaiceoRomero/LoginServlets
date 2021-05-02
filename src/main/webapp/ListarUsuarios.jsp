<%@ page import="org.hibernate.Session"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*, pojos.*, util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listar Usuarios</title>
</head>
<body>

</body>
	<jsp:include page="Header.jsp" flush="false"/>
	<%
	Session s = HibernateUtil.getSessionFactory().openSession();
	List<Usuarios> lista = UsuariosDAO.getAllUsuarios(s);
	s.close();
	%>
	
	<%
	pageContext.setAttribute("listaUsuarios", lista);
	%>
	
	<table class="table" border="solid">
	<tr>
		
		<th>ID</th>
		<th>ID_ROL</th>
		<th>EMAIL</th>
		<th>CLAVE</th>
		<th>NOMBRE</th>
		<th>APELLIDO1</th>
		<th>APELLIDO2</th>
		<th>DIRECCIÓN</th>
		<th>LOCALIDAD</th>
		<th>PROVINCIA</th>
		<th>TELÉFONO</th>
		<th>DNI</th>
	<tr>
		<c:forEach varStatus="status" var="usuario"
            items="${pageScope.listaUsuarios}" begin="0"
            end="${pageScope.listaUsuarios.size() - 1}">
            
            <tr>
                <td><c:out value="${usuario.id}" /></td>
                <td><c:out value="${usuario.idRol}" /></td>
                <td><c:out value="${usuario.email}" /></td>
                <td><c:out value="${usuario.clave}" /></td>
                <td><c:out value="${usuario.nombre}" /></td>
                <td><c:out value="${usuario.apellido1}" /></td>
                <td><c:out value="${usuario.apellido2}" /></td>
                <td><c:out value="${usuario.direccion}" /></td>
                <td><c:out value="${usuario.localidad}" /></td>
                <td><c:out value="${usuario.provincia}" /></td>
                <td><c:out value="${usuario.telefono}" /></td>
                <td><c:out value="${usuario.dni}" /></td>
            </tr>
        </c:forEach>
		
	</table>
</html>