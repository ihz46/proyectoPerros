package com.ipartek.formacion.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutController
 */
@WebServlet("/logout")
public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Puenteamos al doPost
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Obtenemos la session
		HttpSession session = request.getSession();
		
		session.removeAttribute("usuarioLogueado");
		
		//Finalizamos la sesión
		session.invalidate();
		session=null;
		
		
		//Construimos el mensaje, cambiando espacio por %20
		
	    String mensaje = URLEncoder.encode("Muchas gracias por su visita", StandardCharsets.UTF_8.toString());
		
	    
	    //Con esto indicamos la base del proyecto
		String base = request.getContextPath();
		
		//Redirigimos al login
		
		response.sendRedirect(base + "/login.jsp?mensaje=" + mensaje);
		
	}

}
