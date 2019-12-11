package com.ipartek.formacion.listener;

import java.util.HashSet;
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
	Set<String> hashSetDireccionesIP = new HashSet<String>();
	

    public void contextInitialized(ServletContextEvent sce)  { 
       LOG.info("La app se ha arrancado");
       //sc == applicationScope
       
       
       //Obtenemos el contexto de la aplicación
       
       ServletContext sc = sce.getServletContext();
       
       //Añadimos los atributos con valor predeterminado a 0.
       sc.setAttribute("numeroUsuariosConectados", 0);
       sc.setAttribute("numeroIntrusiones",0);
       sc.setAttribute("hashSetDireccionesIP", hashSetDireccionesIP);
    }
   
	
    public void contextDestroyed(ServletContextEvent sce)  { 
      LOG.info("La app se ha parado");   
    }


	
}
