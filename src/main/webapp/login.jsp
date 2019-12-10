<%String titulo = "Perros | Login"; %>
<%@include file="includes/header.jsp" %>


<div class="row">
	<div class="col col-md-6 offset-md-3 text-center">
		<form name="form" class="form" action="login" method="post">
			<div class="form-group">
				<input type="text"  class="form-control" name="nombre" placeholder="Introduce tu nombre" required>
			</div>
			<div class="form-group">
			<input type="password" class="form-control" name="password" placeholder="Introduce tu contraseña" required>
			</div>
			<button type="submit" class="btn btn-primary " >Iniciar Sesión</button>
		
		
		</form>
	</div>

</div>




















<%@include file="includes/footer.jsp"%>