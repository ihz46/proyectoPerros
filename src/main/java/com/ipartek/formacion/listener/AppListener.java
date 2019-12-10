package com.ipartek.formacion.listener;

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
       
       ServletContext sc = sce.getServletContext();
       sc.setAttribute("numeroUsuariosConectados", 0);
    }
   
	
    public void contextDestroyed(ServletContextEvent sce)  { 
      LOG.info("La app se ha parado");   
    }


	
}
