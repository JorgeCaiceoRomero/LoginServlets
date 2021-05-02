<%@ page import="org.hibernate.Session"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*, pojos.*, util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listar Categorías</title>
</head>
<body>
<body>

</body>
	<jsp:include page="Header.jsp" flush="false"/>
	<%
	Session s = HibernateUtil.getSessionFactory().openSession();
	List<Categorias> lista = CategoriasDAO.getAllCategorias(s);
	s.close();
	%>
	
	<%
	pageContext.setAttribute("listaCategorias", lista);
	%>
	
	<table class="table" border="solid">
	<tr>
		
		<th>ID</th>
		<th>NOMBRE</th>
		<th>DESCRIPCIÓN</th>

	<tr>
		<c:forEach varStatus="status" var="categoria"
            items="${pageScope.listaCategorias}" begin="0"
            end="${pageScope.listaCategorias.size() - 1}">
            
            <tr>
                <td><c:out value="${categoria.id}" /></td>
                <td><c:out value="${categoria.nombre}" /></td>
                <td><c:out value="${categoria.descripcion}" /></td>

            </tr>
        </c:forEach>
		
	</table>
</body>

</html>