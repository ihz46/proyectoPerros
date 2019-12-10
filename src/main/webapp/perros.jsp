<%String titulo = "Perros | Perros"; %>
<%@page import="com.ipartek.formacion.model.pojo.Perro"%>
<%@page import="java.util.ArrayList"%>

<%@include file="includes/header.jsp" %>



<h1>Perros</h1>


<%
	
	ArrayList<Perro> perros = (ArrayList<Perro>)request.getAttribute("perros");
	
	String mensaje = (String) request.getAttribute("mensaje");
	
	
	
%>

<p style="color:blue; font-size:2em">${mensaje }</p>

<h2>Listado de perros</h2>


		<table id="tablaPerros" style="text-align:center; td{border:1px,solid,green}">
	
			<thead>
				<tr>
					<th>ID</th><th>NOMBRE</th><th>IMAGEN</th><th>Adoptar/Modificar</th>
				</tr>
			</thead>
			<tbody>
		<% for ( Perro p :  perros ){ %>
				<tr>
				
					<td><%=p.getId()%></td>
					<td><%=p.getNombre()%> </td>
					<td><img src="<%=p.getFoto() %>" alt="imagen alternativa" style="width:100px; height:100px;"/> </td>
					<td><a href="perros?id=<%=p.getId()%>&adoptar=s">Adoptar</a>
						<a href="perros?id=<%=p.getId()%>&editar=s">Modificar</a></td>
				</tr>
		<% } %>
			</tbody>
			
		
		</table>
				




<hr>
<h2>Formulario</h2>

<%
Perro perroEditar = (Perro) request.getAttribute("perroEditar");
	if(perroEditar==null){
		perroEditar = new Perro();
	}

%>

<form action="perros" method="post">
	<input type="text" name="id" required readonly value="<%=perroEditar.getId()%>">
	<br>
		
	<input type="text" name="nombre" placeholder="nombre del bicho" value="<%=perroEditar.getNombre()%>" required>	
	<br>
	
	<input type="text" name="imagen" placeholder="enlace imagen" value="<%=perroEditar.getFoto()%>" required>
	<br>
	
	<input type="submit" value="Enviar">
</form>


<%@include file="includes/footer.jsp" %>