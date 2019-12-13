package com.ipartek.formacion.listener;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.log4j.Logger;

import com.ipartek.formacion.controller.PerrosController;

/**
 * Application Lifecycle Listener implementation class AppListener
 *
 */
@WebListener
public class AppListener implements ServletContextListener {
	
	private final static Logger LOG = Logger.getLogger(AppListener.class);
	
	

    public void contextInitialized(ServletContextEvent sce)  { 
       LOG.info("La app se ha arrancado");
       //sc == applicationScope
       
       
       //Obtenemos el contexto de la aplicación
       
       ServletContext sc = sce.getServletContext();
       
       //Añadimos los atributos con valor predeterminado a 0.
       sc.setAttribute("numeroUsuariosConectados", 0);
       
       //Creamos el ArrayList y lo rellenamos con deportes
       List<String> listaDeportes = new ArrayList<String>();
       
       listaDeportes.add("futbol");
       listaDeportes.add("baloncesto");
       listaDeportes.add("boxeo");
       listaDeportes.add("voleibol");
       listaDeportes.add("beisbol");
       listaDeportes.add("surf");
       listaDeportes.add("hockey");
       listaDeportes.add("rugby");
       listaDeportes.add("skeleton");
       listaDeportes.add("atletismo");
       listaDeportes.add("natacion sincronizada");
       listaDeportes.add("tenis");
       
       
       //Agregamos la lista al contexto de la aplicación, para poder acceder luego a el desde cualquier sitio.
       
       sc.setAttribute("listaDeportes", listaDeportes);
     
    }
   
	
    public void contextDestroyed(ServletContextEvent sce)  { 
      LOG.info("La app se ha parado");   
    }


	
}
