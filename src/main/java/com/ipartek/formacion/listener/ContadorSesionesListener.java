package com.ipartek.formacion.listener;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.log4j.Logger;

/**
 * Application Lifecycle Listener implementation class ContadorSesionesListener
 *
 */
@WebListener
public class ContadorSesionesListener implements HttpSessionAttributeListener, HttpSessionListener {
	
	private final static Logger LOG = Logger.getLogger(ContadorSesionesListener.class);
  
	
    public void attributeAdded(HttpSessionBindingEvent event)  { 
    //Registramos en el log
      LOG.debug("attributeAdded " + event.getName() + " " + event.getValue());
           
    
      
     //Comprobamos el nombre del atributo
      
      if ("usuarioLogueado".equals(event.getName())) {
    	  ServletContext sc = event.getSession().getServletContext();
    	  //Contar usuarios conectados
          int numeroUsers = (int) sc.getAttribute("numeroUsuariosConectados");
          numeroUsers++;
          sc.setAttribute("numeroUsuariosConectados", numeroUsers );
	}
   
      
     
      
    }

	
    public void attributeRemoved(HttpSessionBindingEvent event)  { 
    //Registramos en el log
      LOG.debug("attributeRemoved " + event.getName() + " " + event.getValue());
      
      if ("usuarioLogueado".equals(event.getName())) {
    	  ServletContext sc = event.getSession().getServletContext();
    	  //Contar usuarios conectados
          int numeroUsers = (int) sc.getAttribute("numeroUsuariosConectados");
          numeroUsers--;
          sc.setAttribute("numeroUsuariosConectados", numeroUsers );
      }
    }

	
    public void attributeReplaced(HttpSessionBindingEvent event)  { 
    //Registramos en el log
     LOG.debug("attributeReplaced " + event.getName() + " " + event.getValue());
     
     ServletContext sc = event.getSession().getServletContext();
    }


	@Override
	public void sessionCreated(HttpSessionEvent se) {
	LOG.trace("sessionCreated");
		
	}


	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
	LOG.trace("sessionDestroyed");
		
	}
	
}
