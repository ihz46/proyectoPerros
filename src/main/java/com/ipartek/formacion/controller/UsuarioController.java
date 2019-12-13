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

import org.apache.log4j.Logger;
import org.apache.taglibs.standard.tag.common.core.ForEachSupport;

import com.ipartek.formacion.listener.AppListener;
import com.ipartek.formacion.model.pojo.Usuario;

/**
 * Servlet implementation class UsuarioController
 */
@WebServlet("/usuario")
public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static Logger LOG = Logger.getLogger(UsuarioController.class);   
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Recogemos los parametros del usuario
		String nombre =  request.getParameter("nombre");
		String email =  request.getParameter("email");
		String[] opcionesSeleccionadas = request.getParameterValues("checkbox");
		String sexo = request.getParameter("sexo");
		
		try {
			
			if (opcionesSeleccionadas.length ==0) {
				request.setAttribute("nombre", nombre);
				request.setAttribute("email", email);
				request.setAttribute("mensaje", "Debes de elegir al menos 3 deportes.");
				request.getRequestDispatcher("formUser.jsp").forward(request, response);
			}
			List<String> listaOpciones =  Arrays.asList(opcionesSeleccionadas);
			
			
		
			//Comprobamos que sea válido el email y el nombre tenga más de un caracter
			if (validarEmail(email) && nombre.length()>1) {
				//Comprobamos que haya más de 3 deportes seleccionados
				if (validarDeportes(listaOpciones)) {
					//Comprobamos que no sea null el sexo.
					if (sexo!=null) {
						
						//Instanciamos un nuevo usuario
						Usuario user = new Usuario();
						user.setNombre(nombre);
						user.setEmail(email);
						
						//Añadimos el nuevo usuario como atributo de la peticion
						request.setAttribute("usuario", user);
						
						//También sus opciones
						
						request.setAttribute("listaOpciones", listaOpciones);
						
						//Y su sexo
						switch (sexo) {
						case "h":
							request.setAttribute("sexo", "hombre");
							break;
						case "m":
							request.setAttribute("sexo", "mujer");
							break;
						case "i":
							request.setAttribute("sexo", "indefinido");
							
							break;						}
						
						
						request.getRequestDispatcher("usuarios.jsp").forward(request, response);
					}else {
						request.setAttribute("nombre", nombre);
						request.setAttribute("email", email);
						request.setAttribute("listaOpciones", listaOpciones);
						request.setAttribute("sexo", sexo);
						request.setAttribute("mensaje", "Debes de elegir al menos 3 deportes.");
						request.getRequestDispatcher("formUser.jsp").forward(request, response);
					}
					
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
			
			
			
		
		} catch (Exception e) {
			LOG.error(e.getMessage());
			request.getRequestDispatcher("error.jsp");
			
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
