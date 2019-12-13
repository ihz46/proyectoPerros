<%String titulo = "Perros | Formulario de Usuario"; %>
<%@include file="includes/header.jsp" %>

<c:if test="${not empty mensaje}">
	<p class="error">${mensaje }</p>

</c:if>


		<div class="container">
			<form name="formulario" class="form" action="usuario" method="post">
				<div class="form-group">
					<input type="text" name="nombre" id="nombre" placeholder="Introduce tu nombre" required value="${nombre}">
				</div>
				<div class="form-group">
					<input type="text" name="email" id="email" placeholder="Introduce tu email" required value="${email }">
 				</div>
 <%
 
	 
	
 %>
 
 <!--  
 				
 				<div class="form-check">
 					<input type="checkbox" name="checkbox"  value="futbol">Fútbol 				
 				</div>
 				<div class="form-check">
 					<input type="checkbox" name="checkbox" value="baloncesto">Baloncesto
 				</div>
				<div class="form-check">
					<input type="checkbox" name="checkbox" value="boxeo">Boxeo
				</div> 				
				<div class="form-check">
					<input type="checkbox" name="checkbox" value="voleibol">Voleibol
				</div>
				<div class="form-check">
					<input type="checkbox" name="checkbox" value="beisbol">Béisbol
				</div>
				<div class="form-check">
					<input type="checkbox" name="checkbox" value="surf">Surf
				</div>
				<div class="form-check">
					<input type="checkbox" name="checkbox" value="hockey">Hockey
				</div>
-->				

		<%
			%>
					
				<c:forEach items="${applicationScope.listaDeportes}" var="deporte" varStatus="i">
					
					<div class="form-check">
						
						<input type="checkbox" name="checkbox" value="${deporte}" ${listaOpciones.stream().anyMatch(v->v == deporte ).get() ? 'checked' : '' }> ${deporte}
						
					</div>
				</c:forEach>
				
					<div class="form-group col md-6">
						<select class="form-control" name="sexo">
								<option value="h" ${ (sexo eq 'h') ?"selected":""}>Hombre</option>
								<option value="m" ${ (sexo eq 'm') ?"selected":""}>Mujer</option>
								<option value="i" ${ (sexo eq 'i') ?"selected":""}>Indefinido</option>
						
						</select>
					
					</div>
				
				<button type="submit" class="btn btn-primary">Enviar</button>
			
			
			
			</form>
		
		
		
		</div>

<%@include file="includes/footer.jsp" %>