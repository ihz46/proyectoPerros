package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.taglibs.standard.tag.common.core.ForEachSupport;

import com.ipartek.formacion.model.pojo.Usuario;

/**
 * Servlet implementation class UsuarioController
 */
@WebServlet("/usuario")
public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Recogemos los parametros del usuario
		String nombre = (String) request.getParameter("nombre");
		String email = (String) request.getParameter("email");
		String[] opcionesSeleccionadas = request.getParameterValues("checkbox");
		if (opcionesSeleccionadas.length ==0) {
			request.setAttribute("nombre", nombre);
			request.setAttribute("email", email);
			request.setAttribute("mensaje", "Debes de elegir al menos 3 deportes.");
			request.getRequestDispatcher("formUser.jsp").forward(request, response);
		}
		List<String> listaOpciones =  Arrays.asList(opcionesSeleccionadas);
		
		
		//Instanciamos un nuevo usuario
		Usuario user = new Usuario();
		user.setNombre(nombre);
		user.setEmail(email);
		
		//Comprobamos que sea válido el email
		if (validarEmail(email) && nombre.length()>1) {
			if (validarDeportes(listaOpciones)) {
				//Añadimos el nuevo usuario como atributo de la peticion
				request.setAttribute("usuario", user);
				
				//También sus opciones
				
				request.setAttribute("listaOpciones", listaOpciones);
				
				request.getRequestDispatcher("usuarios.jsp").forward(request, response);
			}else {
				request.setAttribute("nombre", nombre);
				request.setAttribute("email", email);
				request.setAttribute("listaOpciones", listaOpciones);
				request.setAttribute("mensaje", "Debes de elegir al menos 3 deportes.");
				request.getRequestDispatcher("formUser.jsp").forward(request, response);
			}
		
		}else {
			request.setAttribute("nombre", nombre);
			request.setAttribute("email", email);
			request.setAttribute("listaOpciones", listaOpciones);
			request.setAttribute("mensaje", "Debes introducir un email y un nombre válido.");
			request.getRequestDispatcher("formUser.jsp").forward(request, response);
		}
		
		
		
	}
	
	
	private boolean validarDeportes(List<String> listaDeportes) {
		if (listaDeportes != null && listaDeportes.size() >=3) {
			return true;
		}else {
			return false;
		}
	}
	private boolean validarEmail(String email) {
		Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		Matcher mather = pattern.matcher(email);
		 
		if (mather.find() == true) {
			return true;
		}else {
			return false;
		}
		
		
	}
	
	
	

}
