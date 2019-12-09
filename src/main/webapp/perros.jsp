<%String titulo = "Perros | ¨Perros"; %>
<%@page import="com.ipartek.formacion.model.pojo.Perro"%>
<%@page import="java.util.ArrayList"%>

<%@include file="includes/header.jsp" %>
<%@include file="includes/navigation.jsp" %>


<h1>Perros</h1>


<%
	
	ArrayList<Perro> perros = (ArrayList<Perro>)request.getAttribute("perros");
	
	String mensaje = (String) request.getAttribute("mensaje");
	
	Perro perroEditar = (Perro) request.getAttribute("perro");
	if(perroEditar==null){
		perroEditar = new Perro();
	}
	
%>

<p style="color:blue; font-size:2em">${mensaje }</p>

<h2>Listado de perros</h2>

<ul>
	<% for ( Perro p :  perros ){ %>
	
		<li><%=p.getId()%> - <%=p.getNombre()%> <img src="<%=p.getFoto() %>" alt="imagen alternativa" style="width:100px; height:100px;"/>  </li>
		<a href="perros?id=<%=p.getId()%>&adoptar=s">Adoptar</a>
		<a href="perros?id=<%=p.getId()%>&modificar=s">Modificar</a>
		
	<% } %>
</ul>

<hr>

formulario

<form action="perros" method="post">
	
	<input type="text" name="nombre" placeholder="nombre del bicho" required>	
	
	<input type="text" name="imagen" placeholder="enlace imagen" required>
	
	<input type="submit" value="Enviar">
</form>


<%@include file="includes/footer.jsp" %>