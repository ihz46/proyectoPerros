package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ipartek.formacion.model.pojo.Perro;

/**
 * Servlet implementation class PerrosController
 */
@WebServlet("/perros2")
public class PerrosController2 extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
	private String mensaje= "";
	private final static Logger log = Logger.getLogger(PerrosController2.class);
	private ArrayList<Perro> perros = new ArrayList<Perro>();
    private int indice=0;
    
   
	

	public PerrosController2() {
		super();
		
	}
	
	

	@Override
	public void init(ServletConfig config) throws ServletException {
		log.trace("Método init, se ejecuta la primera vez que se llama al servlet y nunca más.");
		super.init(config);
		perros.add( new Perro(1,"bubba") );
		perros.add( new Perro(2,"rataplan") );
		perros.add( new Perro(3,"mosca") );
		perros.add( new Perro(4,"txakur") );
		perros.add( new Perro(5,"lagun") );
		indice=6;
		
	}
	
	@Override
	public void destroy() {
		log.debug("Se ejecuta solo una vez cuando se para el servidor de aplicaciones");
		super.destroy();
		perros=null;
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.trace("Se ejecuta antes del doGet o doPost");//
		mensaje="";
		super.service(request, response);
		
	
		log.warn("Se ejecuta después del doGet o doPost");
		
		request.setAttribute("mensaje", mensaje);
		request.setAttribute("perros", perros);
		request.getRequestDispatcher("perros-jstl.jsp").forward(request, response);
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.trace("doGet");
		
		int id = (request.getParameter("id") ==null) ? 0 : Integer.parseInt(request.getParameter("id"));
		
		boolean editar =(request.getParameter("editar") ==null)? false:true;
		boolean adoptar = (request.getParameter("adoptar") == null)? false:true;
		
		log.debug("id= " + id + ", adoptar = " + adoptar + " , editar = " + editar);
		
		if (id>0) {
			//buscamos perro en array;
			Perro perro = null;
				for (Perro p : perros) {
					if(p.getId() == id) {
						perro = p;
						break;
					}
				}
				
				
			
			if (adoptar) {
				perros.remove(perro);
				mensaje = "Ya has adoptado al perro, gracias por ayudar.";
				log.info("Se ha adoptado el perro " + perro.getNombre());
			}
			
			if (editar) {
				request.setAttribute("perroEditar", perro);
			}
			
		}else {
			log.trace("Listamos los perros");
			
			
		}
		
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		log.trace("doPost");
		//recibir datos del form
		
		//TODO validar nombre y imagen
		int id = Integer.parseInt(request.getParameter("id"));
		String nombre = request.getParameter("nombre");
		String imagen = request.getParameter("imagen");
		
				
		log.trace("crear perro");
		if (id>0) {
			log.trace("editamos el perro");
			Perro perro = null;
			for (Perro p : perros) {
				if (p.getId()==id) {
					perro=p;
					break;
				}
			}
			perro.setNombre(nombre);
			perro.setFoto(imagen);
			mensaje = "Perro modificado con éxito";
			
		}else {
			log.trace("Creamos un nuevo perro");
			Perro p = new Perro();
			p.setId(indice);
			p.setNombre(nombre);
			p.setFoto(imagen);
			p.setId(indice);
			indice++;
			
			mensaje = "Gracias por sacrificar un nuevo perro";
			
			log.trace("añadimos el perro a la lista");
			perros.add(p);
			
		}
		
		
				
		log.trace("vamos a otra vista");
		
	
	}

}
