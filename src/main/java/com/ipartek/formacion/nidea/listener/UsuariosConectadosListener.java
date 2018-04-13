package com.ipartek.formacion.nidea.listener;

import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.ipartek.formacion.nidea.pojo.Usuario;

/**
 * Application Lifecycle Listener implementation class UsuariosConectadosListener
 *
 */
@WebListener
public class UsuariosConectadosListener implements HttpSessionListener, HttpSessionAttributeListener {

	/**
	 * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
	 */
	public void sessionCreated(HttpSessionEvent se) {

	}

	/**
	 * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
	 */
	public void sessionDestroyed(HttpSessionEvent se) {
		if (se.getSession().getAttribute("uPublic") != null) {
			Usuario user = (Usuario) se.getSession().getAttribute("uPublic");

			ServletContext ctx = se.getSession().getServletContext();

			if (ctx.getAttribute("usuariosConectados") == null) {
				HashMap<Integer, Usuario> hmusuarios = (HashMap<Integer, Usuario>) ctx.getAttribute("usuariosConectados");
				hmusuarios.remove(user.getId(), user);
				ctx.setAttribute("usuariosConectados", hmusuarios);
			}
		}
	}

	/**
	 * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
	 */
	public void attributeAdded(HttpSessionBindingEvent event) {
		// comprobar que sea atributo == uPublic
		if ("uPublic".equals(event.getName())) {
			// contexto de la aplicacion
			ServletContext ctx = event.getSession().getServletContext();

			Usuario user = (Usuario) event.getValue();

			HashMap<Integer, Usuario> hmusuarios = null;
			if (ctx.getAttribute("usuariosConectados") == null) {
				hmusuarios = new HashMap<Integer, Usuario>();
			} else {
				hmusuarios = (HashMap<Integer, Usuario>) ctx.getAttribute("usuariosConectados");
			}
			hmusuarios.put(user.getId(), user);
			ctx.setAttribute("usuariosConectados", hmusuarios);
		}
	}

	/**
	 * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
	 */
	public void attributeRemoved(HttpSessionBindingEvent event) {

	}

	/**
	 * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
	 */
	public void attributeReplaced(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
	}

}
