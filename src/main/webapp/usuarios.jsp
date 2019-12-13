<%String titulo = "Perros | Lista de usuarios"; %>
<%@include file="includes/header.jsp" %>
<h2>Usuarios</h2>

<% %>

<p>Nombre: ${usuario.nombre}</p>
<p>Email: ${usuario.email}</p>
<p>Sexo: ${sexo }
<ol>
	<c:forEach items="${listaOpciones}" var="opcion">
		<li>${opcion}</li>
	</c:forEach>
</ol>


<%@include file="includes/footer.jsp" %>