package com.ipartek.formacion.filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.ipartek.formacion.controller.PerrosController;

/**
 * Servlet Filter implementation class SeguridadFilter
 */
@WebFilter(dispatcherTypes = { DispatcherType.REQUEST, DispatcherType.FORWARD, DispatcherType.INCLUDE,
		DispatcherType.ERROR }, urlPatterns = { "/SeguridadFilter", "/private/*" })
public class SeguridadFilter implements Filter {
	private final static Logger LOG = Logger.getLogger(SeguridadFilter.class);

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		LOG.trace("destroy filter");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;

		HttpSession session = req.getSession();

		if (session.getAttribute("usuarioLogueado") == null) {

			LOG.warn("Intrusión no deseada");

			LOG.debug("RequestURL: " + req.getRequestURL());
			LOG.debug("RequestURI: " + req.getRequestURI());
			LOG.debug("Remote Host: " + req.getRemoteHost());
			LOG.debug("Remote Address: " + req.getRemoteAddr());

			Map<String, String[]> map = request.getParameterMap();
			for (Object key : map.keySet()) {

				System.out.println("Key " + key + "   :   " + map.get(key)[0].toString());
			}

		} else {
			// Dejamos continuar
			chain.doFilter(request, response);
		}

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		LOG.trace("init filter");
	}

}
