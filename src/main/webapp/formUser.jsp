<%String titulo = "Perros | Formulario de Usuario"; %>
<%@include file="includes/header.jsp" %>

<c:if test="${not empty mensaje}">
	<p class="error">${mensaje }</p>

</c:if>


		<div class="container">
			<form name="formulario" class="form" action="usuario" method="post">
				<div class="form-group">
					<input type="text" name="nombre" id="nombre" placeholder="Introduce tu nombre" required>
				</div>
				<div class="form-group">
					<input type="text" name="email" id="email" placeholder="Introduce tu email" required>
 				</div>
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
				
				<button type="submit" class="btn btn-primary">Enviar</button>
			
			
			
			</form>
		
		
		
		</div>

<%@include file="includes/footer.jsp" %>