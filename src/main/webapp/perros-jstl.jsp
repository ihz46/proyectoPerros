<%String titulo = "Perros | PerrosJSTL"; %>

<%@include file="includes/header.jsp" %>



<h1>Perros con JSTL</h1>
<p>Mismo ejemplo para hacer un CRUD pero usando taglib y EL(Expression Languages)</p>

<p style="color:blue; font-size:2em">${mensaje }</p>

<h2>Listado de perros</h2>
<h2>Tenemos ${fn:length(perros)} perros en adopción</h2>

		<table id="tablaPerros" style="text-align:center; td{border:1px,solid,green}">
	
			<thead>
				<tr>
					<th>ID</th><th>NOMBRE</th><th>IMAGEN</th><th>Adoptar/Modificar</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${perros}" var="p">
				<tr>
				
					<td>${p.id}</td>
					<td>${p.nombre }</td>
					<td><img src="${p.foto}" alt="imagen alternativa" style="width:100px; height:100px;"/> </td>
					<td><a href="perros2?id=${p.id}&adoptar=s">Adoptar</a>
						<a href="perros2?id=${p.id}&editar=s">Modificar</a></td>
				</tr>
				</c:forEach>
			</tbody>
			
		
		</table>
		
<h2>Formulario</h2>

<c:if test="${empty perroEditar}">
	No hay ningún perro para editar, vamos a inicializarlo.
	<jsp:useBean id="perroEditar" class="com.ipartek.formacion.model.pojo.Perro"></jsp:useBean>
</c:if>

		
		
<form action="perros2" method="post">
	<input type="text" name="id" required readonly value="${perroEditar.id}">
	<br>
		
	<input type="text" name="nombre" placeholder="nombre del bicho" value="${perroEditar.nombre}" required>	
	<br>
	
	<input type="text" name="imagen" placeholder="enlace imagen" value="${perroEditar.foto}" required>
	<br>
	
	<input type="submit" value="Enviar">
</form>


<%@include file="includes/footer.jsp" %>