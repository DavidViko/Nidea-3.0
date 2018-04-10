package com.ipartek.formacion.nidea.controller.backoffice;

import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.nidea.model.MaterialDAO;
import com.ipartek.formacion.nidea.pojo.Alert;
import com.ipartek.formacion.nidea.pojo.Material;

/**
 * Servlet implementation class MaterialesController
 */
@WebServlet("/backoffice/materiales")
public class MaterialesBackController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String VIEW_INDEX = "materiales/index.jsp";
	private static final String VIEW_FORM = "materiales/form.jsp";

	public static final int OP_MOSTRAR_FORMULARIO = 1;
	public static final int OP_BUSQUEDA = 14;
	public static final int OP_ELIMINAR = 13;
	public static final int OP_GUARDAR = 2;

	private RequestDispatcher dispatcher;
	private Alert alert = null;
	private MaterialDAO dao;

	private String precioString;

	// parametros del material
	private int id;
	private String nombre;
	private float precio;

	// parametros comunes
	private String search; // buscador por nombre material
	private int op; // operacion a realizar

	/**
	 * Para cargar el DAO segun se inicia el servlet. No se hace por cada peticion
	 * get o post
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		dao = MaterialDAO.getInstance();
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
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Antes de ejecutar doGet o do Post");
		super.service(request, response);// llama al doGet o doPost
		System.out.println("Despues de ejecutar doGet o do Post");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * Unimos las peticiones doGet y doPost, para que se haga lo mismo desde ambas
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			alert = null;
			recogerParametros(request);

			switch (this.op) {
			case OP_MOSTRAR_FORMULARIO:
				mostrarFormulario(request);
				break;
			case OP_ELIMINAR:
				eliminar(request);
				break;
			case OP_BUSQUEDA:
				buscar(request);
				break;
			case OP_GUARDAR:
				guardar(request);
				break;
			default:
				listar(request);
				break;
			}

			// Se quita de aqui para pasarlo al init.
			// MaterialDAO dao = MaterialDAO.getInstance();

			// dispatcher = request.getRequestDispatcher(VIEW_INDEX);
		} catch (Exception e) {
			alert = new Alert();
			e.printStackTrace();

		} finally {
			op = -1;

			request.setAttribute("alert", alert);
			dispatcher.forward(request, response);
		}

	}

	private void guardar(HttpServletRequest request) {
		Material material = new Material();
		try {
			material.setId(id);
			material.setNombre(nombre);
			precio = Float.parseFloat(precioString);
			material.setPrecio(precio);
			if (precio < 0) {
				alert = new Alert("ERROR. El precio debe ser mayor que 0", Alert.TIPO_WARNING);
			} else if (nombre.equals("")) {
				alert = new Alert("ERROR. El nombre no puede estar vacio", Alert.TIPO_WARNING);
			} else if (nombre.length() > 45) {
				alert = new Alert("ERROR. El nombre es demasiado largo", Alert.TIPO_WARNING);
			} else {
				try {
					if (id == -1) {
						if (dao.save(material)) {
							alert = new Alert("Material creado", Alert.TIPO_PRIMARY);
						} else {
							alert = new Alert("ERROR. No se puedo guardar", Alert.TIPO_WARNING);
						}
					} else {
						if (dao.save(material)) {
							alert = new Alert("Modificado material con id " + id, Alert.TIPO_PRIMARY);
						} else {
							alert = new Alert("ERROR. No se puedo modificar", Alert.TIPO_WARNING);
						}
					}
				} catch (SQLIntegrityConstraintViolationException e) {
					alert = new Alert("ERROR. El material ya existe", Alert.TIPO_WARNING);
				}
			}
		} catch (NumberFormatException e) {
			alert = new Alert("PRECIO ERRONEO. No puede contener letras", Alert.TIPO_WARNING);
		}

		request.setAttribute("material", material);
		dispatcher = request.getRequestDispatcher(VIEW_FORM);

	}

	private void buscar(HttpServletRequest request) {
		alert = new Alert("Busqueda para: " + search, Alert.TIPO_PRIMARY);
		ArrayList<Material> materiales = new ArrayList<Material>();
		materiales = dao.getByName(search);
		request.setAttribute("materiales", materiales);
		dispatcher = request.getRequestDispatcher(VIEW_INDEX);
	}

	private void eliminar(HttpServletRequest request) {
		if (dao.delete(id)) {
			alert = new Alert("Material Eliminado id " + id, Alert.TIPO_PRIMARY);
		} else {
			alert = new Alert("Error Eliminando, sentimos las molestias ", Alert.TIPO_WARNING);
		}
		listar(request);
	}

	private void mostrarFormulario(HttpServletRequest request) {
		Material material = new Material();
		if (id > -1) {
			alert = new Alert("Mostramos Detalle id:" + id, Alert.TIPO_WARNING);
			material = dao.getById(id);

		} else {
			alert = new Alert("Nuevo Producto", Alert.TIPO_WARNING);
		}
		request.setAttribute("material", material);
		dispatcher = request.getRequestDispatcher(VIEW_FORM);

	}

	private void listar(HttpServletRequest request) {
		ArrayList<Material> materiales = new ArrayList<Material>();
		materiales = dao.getAll();
		request.setAttribute("materiales", materiales);
		dispatcher = request.getRequestDispatcher(VIEW_INDEX);

	}

	/**
	 * Recogemos todos los posibles metodos emviados
	 * 
	 * @param request
	 */
	private void recogerParametros(HttpServletRequest request) {
		if (request.getParameter("op") != null) {
			op = Integer.parseInt(request.getParameter("op"));
		}

		search = (request.getParameter("search") != null) ? request.getParameter("search") : "";

		if (request.getParameter("id") != null) {
			id = Integer.parseInt(request.getParameter("id"));
		}

		if (request.getParameter("nombre") != null) {
			nombre = request.getParameter("nombre").trim();
		}

		if (request.getParameter("precio") != null) {
			precioString = request.getParameter("precio");
		}
	}
}
