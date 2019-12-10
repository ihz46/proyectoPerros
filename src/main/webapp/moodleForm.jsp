<%String titulo = "Perros | Moodle"; %>
<%@include file="includes/header.jsp" %>

<form class="form-inline" role="form" action="http://www.campus.formacion.ipartek.com/moodle/login/index.php" method="post">
  <div class="form-group">
    <label for="username">Username:</label>
    <input type="text" name="username" class="form-control" id="username">
  </div>
  <div class="form-group">
    <label for="pwd">Password:</label>
    <input type="password" name="password" class="form-control" id="password">
  </div>
  <button type="submit" class="btn btn-primary col-sm-2">Acceder</button>
</form>

<%@include file="includes/footer.jsp" %>