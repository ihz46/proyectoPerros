<%String titulo = "Perros | Login"; %>

<!-- Indicamos la página de error -->
<%@ page errorPage="error500.jsp" %>

<%@include file="includes/header.jsp" %>

<!-- Descomentar estas lineas para que lance un error
<%//Object o = null;
//o.toString(); %> -->

<c:if test="${not empty param.mensaje}">

	<h2 style="color:black;">${param.mensaje}</h2>
</c:if>



<h1>LOGIN</h1>
<h2>${mensaje}</h2>
<div class="row">
	<div class="col col-md-6 offset-md-3 text-center">
		<form name="form" class="form" action="login" method="post">
			<div class="form-group">
				<input type="text"  class="form-control" name="nombre" placeholder="Introduce tu nombre" required value="admin">
			</div>
			<div class="form-group">
			<input type="password" class="form-control" name="password" placeholder="Introduce tu contraseña" required value="admin1234">
			</div>
			<button type="submit" class="btn btn-primary " >Iniciar Sesión</button>
		
		
		</form>
	</div>

</div>




















<%@include file="includes/footer.jsp"%>