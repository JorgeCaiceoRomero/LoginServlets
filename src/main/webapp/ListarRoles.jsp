<%@ page import="org.hibernate.Session"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*, pojos.*, util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listar Roles</title>
</head>
<body>

</body>
	<jsp:include page="Header.jsp" flush="false"/>
	<%
	Session s = HibernateUtil.getSessionFactory().openSession();
	List<Roles> listaRoles = RolesDAO.getAllRoles(s);
	s.close();
	%>
	
	<%
	pageContext.setAttribute("listaRoles", listaRoles);
	%>
	
	<table class="table" border="solid">
	<tr>
		
		<th>Rol</th>
	<tr>
		<c:forEach varStatus="status" var="rol"
            items="${pageScope.listaRoles}" begin="0"
            end="${pageScope.listaRoles.size() - 1}">
            
            <tr>
                <td><c:out value="${rol.rol}" /></td>
                
            </tr>
        </c:forEach>
		
	</table>
</html>