<%String titulo = "Perros | Login"; %>
<%@include file="includes/header.jsp" %>
<%@include file="includes/navigation.jsp" %>


<form name="formulario" action="login" method="post">
	<input type="text" name="nombre" placeholder="Introduce tu nombre" required>
	<input type="password" name="password" placeholder="Introduce tu contrase�a" required>
	
	<input type="submit" value="Iniciar Sesi�n">


</form>





















<%@include file="includes/footer.jsp"%>