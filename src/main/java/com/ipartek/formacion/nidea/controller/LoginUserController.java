package com.ipartek.formacion.nidea.controller;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.nidea.pojo.Alert;
import com.ipartek.formacion.nidea.pojo.Usuario;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/loginUser")
public class LoginUserController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private String view = "";
	private Alert alert = new Alert();

	private static final int SESSION_EXPIRATION = 1; // 10 minutos

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("login2.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String usuario = request.getParameter("usuario");
			int id = Integer.parseInt(request.getParameter("id"));
			Usuario user = new Usuario(id, usuario);

			// guardar usuario en sesion
			HttpSession session = request.getSession();
			session.setAttribute("uPublic", user);
			session.setMaxInactiveInterval(SESSION_EXPIRATION);

			view = "usuarioSesion.jsp";
			alert = new Alert("Ongi Etorri", Alert.TIPO_PRIMARY);

		} catch (Exception e) {
			e.printStackTrace();
			view = "login2.jsp";
			alert = new Alert();

		} finally {
			request.setAttribute("alert", alert);
			request.getRequestDispatcher(view).forward(request, response);
		}

	}

}
