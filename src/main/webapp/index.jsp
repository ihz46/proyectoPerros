<%String titulo = "Perros | Inicio"; %>
<%@include file="includes/header.jsp" %>

<%
	
	out.print("<h1>Soy index.jsp</h1>");

%>

<a href="perros">CRUD Perros</a>
<a href="perros2">CRUD Perros con JSTL</a>


<%@include file="includes/footer.jsp" %>