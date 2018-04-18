package com.ipartek.formacion.nidea.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.nidea.model.UsuarioDAO;
import com.ipartek.formacion.nidea.pojo.Alert;
import com.ipartek.formacion.nidea.pojo.Usuario;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private String view = "";
	private Alert alert = new Alert();

	private static final String USER = "admin";
	private static final String PASS = "admin";

	private UsuarioDAO dao = null;

	private static final int SESSION_EXPIRATION = 60 * 10; // 10 minuto

	/**
	 * Para cargar el DAO segun se inicia el servlet. No se hace por cada peticion get o post
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		dao = UsuarioDAO.getInstance();
	}

	/**
	 * Se ejecuta cuando paramos el servidor de aplicaciones (Tomcat)
	 */
	@Override
	public void destroy() {
		super.destroy();
		dao = null;
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.service(request, response);// llama al doGet o doPost
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("login.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario user = null;
		try {
			String usuario = request.getParameter("usuario");
			String password = request.getParameter("password");
			user = dao.checkUsuario(usuario, password);
			if (user != null) {
				if (user.getRol().getId() == 1) {
					// guardar usuario en sesion
					HttpSession session = request.getSession();
					session.setAttribute("usuario", usuario);

					/*
					 * tiempo de expiracion de sesion. Tambien se puede configurar en el web.xml Un valor negativo, indica que nunca expira <session-config>
					 * <session-timeout>-1</session-timeout> </session-config>
					 */
					session.setMaxInactiveInterval(SESSION_EXPIRATION);

					view = "backoffice/index.jsp";
					alert = new Alert("Ongi Etorri " + usuario, Alert.TIPO_PRIMARY);
				} else {
					// guardar usuario en sesion
					HttpSession session = request.getSession();
					session.setAttribute("uPublic", user);
					session.setMaxInactiveInterval(SESSION_EXPIRATION);

					view = "usuarioSesion.jsp";
					alert = new Alert("Ongi Etorri " + usuario, Alert.TIPO_PRIMARY);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			view = "login.jsp";
			alert = new Alert();

		} finally {
			request.setAttribute("alert", alert);
			request.getRequestDispatcher(view).forward(request, response);
		}

	}

}
