<%String titulo = "Perros | Inicio"; %>
<%@include file="includes/header.jsp" %>

<%
	
	out.print("<h1>Soy index.jsp</h1>");

%>
<h2> CRUD CON Y SIN JSTL</h2>

<a href="perros">CRUD Perros</a>
<a href="perros2">CRUD Perros con JSTL</a>


<h2>SEGURIDAD</h2>

<a href="private/home">Enlace para filtro</a>
<%@include file="includes/footer.jsp" %>