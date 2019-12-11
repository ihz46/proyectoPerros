<%@page isErrorPage="true" %>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>ERROR 500</title>
</head>
<body>
	<h1>Aprende a programar</h1>


<!-- Stack trace -->
<jsp:scriptlet>
	
	  exception.printStackTrace(new java.io.PrintWriter(out));
	
</jsp:scriptlet>


</body>
</html>