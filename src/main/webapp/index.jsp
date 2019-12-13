<%String titulo = "Perros | Inicio"; %>
<%@include file="includes/header.jsp" %>

<h2>Branch Modelo</h2>
<section>
<h2> CRUD </h2>

<ul>
<li><a href="perros">CRUD Perros</a></li>
<li><a href="perros2">CRUD Perros con JSTL</a></li>
</ul>

</section>

<section>
<h2>SEGURIDAD</h2>
<ul>
<li><a href="private/home">Enlace para saltar filtro</a></li>
</ul>

</section>

<section>
<h2>USUARIOS</h2>
<ul>
<li><a href="formUser.jsp">Formulario de usuarios</a></li>
<li><a href="login.jsp">Login</a></li>
</ul>



</section>
<%@include file="includes/footer.jsp" %>