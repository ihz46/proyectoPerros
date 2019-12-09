package com.ipartek.formacion.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.model.pojo.Usuario;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//Constantes de usuario para acceder.
	private static final String NOMBRE="admin";
	private static final String PASSWORD="admin1234";
	
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Puenteamos a dopost
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. Recibimos los parámetros 
				String nombre= (String) request.getParameter("nombre");
				String password = (String) request.getParameter("password");
				
				
		
				
		//2. Comprobamos que sea el usuario correcto, en caso contrario se le mostrará una página de error.
				
		if (NOMBRE.equalsIgnoreCase(nombre) && PASSWORD.equals(password)) {
			
			//Creamos una nueva instancia del usuario
			
			Usuario usuario = new Usuario();
			
			usuario.setNombre(nombre);
			usuario.setImagen("https://disenopaginasweb.club/wp-content/uploads/2019/04/usuario.png");
			
			//Obtenemos la sesión
			
			HttpSession session = request.getSession();
			
			//Establecemos el tiempo máximo de la sesión
			
			session.setMaxInactiveInterval(5*60);//5 minutos
			
			//Guardamos los atributos en la sesión
			
			session.setAttribute("usuarioLogueado", usuario);
			
			//Le enviamos a la página de perros
			
			response.sendRedirect("perros");
			
		}else {
			
			//Le enviamos a la página de error
						
			response.sendRedirect("error.jsp");
			
			
			
		}
	}

}
