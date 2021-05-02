<%@ page import="org.hibernate.Session"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*, pojos.*, util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listado Productos</title>
</head>
<body>
<jsp:include page="Header.jsp" flush="false"/>
	<%
	Session s = HibernateUtil.getSessionFactory().openSession();
	List<Productos> lista = ProductosDAO.getAllProductos(s);
	s.close();
	%>
	
	<%
	pageContext.setAttribute("listaProdutos", lista);
	%>
	
	<table class="table" border="solid">
	<tr>
		
		<th>ID</th>
		<th>ID_CATEGORÍA</th>
		<th>NOMBRE</th>
		<th>DESCRIPCIÓN</th>
		<th>PRECIO</th>
		<th>STOCK</th>
		<th>FECHA ALTA</th>
		<th>FECHA BAJA</th>
		<th>IMPUESTO</th>
	<tr>
		<c:forEach varStatus="status" var="producto"
            items="${pageScope.listaProductos}" begin="0"
            end="${pageScope.listaProductos.size() - 1}">
            
            <tr>
                <td><c:out value="${producto.id}" /></td>
            	<td><c:out value="${producto.idCategoria}" /></td>
            	<td><c:out value="${producto.nombre}" /></td>
            	<td><c:out value="${producto.descripcion}" /></td>
            	<td><c:out value="${producto.precio}" /></td>
            	<td><c:out value="${producto.stock}" /></td>
            	<td><c:out value="${producto.fechaAlta}" /></td>
            	<td><c:out value="${producto.fechaBaja}" /></td>
            	<td><c:out value="${producto.impuesto}" /></td>
            </tr>
        </c:forEach>
		
	</table>
</body>
</html>