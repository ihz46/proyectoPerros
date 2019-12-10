<%String titulo = "Perros | Login"; %>
<%@include file="includes/header.jsp" %>



<form name="formulario" action="login" method="post">
	<input type="text" name="nombre" placeholder="Introduce tu nombre" required>
	<input type="password" name="password" placeholder="Introduce tu contraseña" required>
	
	<input type="submit" value="Iniciar Sesión">


</form>





















<%@include file="includes/footer.jsp"%>