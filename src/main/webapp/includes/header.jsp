
<%@page import="com.ipartek.formacion.model.pojo.Usuario"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="icon" type="image/jpg" href="images/icons/logoIpartekWeb.jpg" />
	 <base href="/perros/"></base>
	 <title><%=titulo%></title>
	 
	 <!-- FUENTES -->
	 <link href="https://fonts.googleapis.com/css?family=Calistoga&display=swap" rel="stylesheet">
	 
	 <!-- FONT-AWESOME -->
	 <link rel = "stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.css">
	 
	 <!-- OWN CSS STYLES -->
	 <link rel="stylesheet" href="css/styles.css?time=<%=System.currentTimeMillis()%>">
	 
	 	 
</head>

<body id="#top">
<header>
		<%
			//Obtenemos los datos del usuario para pintar en el JSP.
			Usuario user = (Usuario) session.getAttribute("usuarioLogueado");
			//En caso de que no haya ningún dato, no pintamos nada
			
			if(user!=null){%>
				<div class="info-user">
					<p>Bienvenido <%=user.getNombre() %> </p>
					<img  src="<%=user.getImagen()%>" alt="logo del usuario">		
					<a href="logout"><i class="fas fa-times-circle"></i></a>
				</div>
			<%
			
			
			}%>
		
		
	
	
</header>
<main>
