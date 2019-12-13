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

import com.ipartek.formacion.model.ArrayPerroDAO;
import com.ipartek.formacion.model.pojo.Perro;

/**
 * Servlet implementation class PerrosController
 */
@WebServlet("/perros")
public class PerrosController extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
	private String mensaje= "";
	private final static Logger log = Logger.getLogger(PerrosController.class);
	private static ArrayPerroDAO dao = ArrayPerroDAO.getInstance();
    
   
	

	public PerrosController() {
		super();
		
	}
	
	

	@Override
	public void init(ServletConfig config) throws ServletException {
		log.trace("Método init, se ejecuta la primera vez que se llama al servlet y nunca más.");
		super.init(config);
		try {
			dao.create( new Perro("bubba") );
			dao.create( new Perro("rataplan") );
			dao.create( new Perro("mosca") );
			dao.create( new Perro("txakur") );
			dao.create( new Perro("lagun") );
			
		} catch (Exception e) {
			log.warn(e.getMessage());
		}
		
		
	}
	
	@Override
	public void destroy() {
		log.debug("Se ejecuta solo una vez cuando se para el servidor de aplicaciones");
		super.destroy();
		
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.trace("Se ejecuta antes del doGet o doPost");//
		mensaje="";
		super.service(request, response);
		
	
		log.warn("Se ejecuta después del doGet o doPost");
		
		request.setAttribute("mensaje", mensaje);
		request.setAttribute("perros", dao.getAll());
		request.getRequestDispatcher("perros.jsp").forward(request, response);
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
			Perro perro = dao.getById(id);
				
						
			if (adoptar) {
				try {
					dao.delete(id);
					mensaje = "Ya has adoptado al perro, gracias por ayudar.";
					log.info("Se ha adoptado el perro " + perro.getNombre());
				} catch (Exception e) {
					log.info("No se puede eliminar el perro");
				}
				
			}
			
			if (editar) {
				try {
					dao.update(perro);
					request.setAttribute("perroEditar", perro);
				} catch (Exception e) {
					log.warn("No se ha podido actualizar el perro");
				}
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
		
				
		
		if (id>0) {
			log.trace("editamos el perro");
			Perro perro = new Perro();
			perro.setId(id);
			perro.setNombre(nombre);
			perro.setFoto(imagen);
			
			try {
				dao.update(perro);
				mensaje = "Perro modificado con éxito";
			} catch (Exception e) {
				mensaje = "No se pudo modificar el perro";
			}
			
			
		}else {
			log.trace("Creamos un nuevo perro");
			Perro p = new Perro();
			p.setNombre(nombre);
			p.setFoto(imagen);
			try {
				dao.create(p);
				mensaje = "Gracias por añadir un nuevo perro";
			} catch (Exception e) {
				mensaje="No se puede crear el perro";
			}
			
		
			
			
		}
		
		
				
		log.trace("vamos a otra vista");
		
	
	}

}
