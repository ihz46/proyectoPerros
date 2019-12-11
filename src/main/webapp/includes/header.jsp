<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@page import="com.ipartek.formacion.model.pojo.Usuario"%>



<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="icon" type="image/png" href="img/dog.png" />
	  <base href="${pageContext.request.contextPath}/"></base>
	 <!--<base href="/perros/"></base>  -->
	 <title><%=titulo%></title>
	 
	 <!-- FUENTES -->
	 <link href="https://fonts.googleapis.com/css?family=Calistoga&display=swap" rel="stylesheet">
	 
	 <!-- FONT-AWESOME -->
	 <link rel = "stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.css">
	 
	 <!-- DATATABLES -->
	 <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.20/css/jquery.dataTables.css">
	 
	 <!--  BOOTSTRAP -->
	 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	 
	 <!-- OWN CSS STYLES -->
	 <link rel="stylesheet" href="css/styles.css?time=<%=System.currentTimeMillis()%>">
	 
	 	 
</head>

<body id="#top">
<header>
<ul class="nav nav-pills mb-10">
  <li class="nav-item">
    <a class="nav-link active" href="index.jsp">Inicio</a>
  </li>
  <li class="nav-item ">
   	<a class="nav-link" href="login.jsp">Login</a>
  </li>
  <li class="nav-item ">
    <a class="nav-link" href="moodleForm.jsp">Moodle</a>
  </li>
  <li class="nav-item">
  	<a class="nav-link" href="perros">Perros</a>
  <li class="nav-item">
  	<p class="usuarios">Usuarios Conectados: ${applicationScope.numeroUsuariosConectados}</p>
  </li>
  
  
</ul>
		<c:if test="${not empty usuarioLogueado }">
			<div class="info-user">
					<p>Bienvenido ${usuarioLogueado.nombre} </p>
					<img  src="${usuarioLogueado.imagen }" alt="logo del usuario">		
					<a href="logout"><i class="fas fa-times-circle"></i></a>
			</div>
			<p>Numero de intrusiones: ${applicationScope.numeroIntrusiones }</p>
			
				<c:forEach items="${applicationScope.hashSetDireccionesIP}" var="direccionIp">
					<p>direccionIp</p>
				</c:forEach>
			
		</c:if>
		 
			
		
		
	
	
</header>

<main>
<div class="container">
