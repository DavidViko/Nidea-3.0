package com.ipartek.formacion.nidea.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ipartek.formacion.nidea.pojo.Material;

public class MaterialDAO implements Persistible<Material> {

	private static MaterialDAO INSTANCE = null;

	// Private constructor para que no se pueda hacer new y crear N instancias
	private MaterialDAO() {
	}

	// creador sincronizado para protegerse de posibles problemas multi-hilo
	// otra prueba para evitar instanciación múltiple

	private synchronized static void createInstance() {
		if (INSTANCE == null) {
			INSTANCE = new MaterialDAO();
		}
	}

	public static MaterialDAO getInstance() {
		if (INSTANCE == null)
			createInstance();
		return INSTANCE;
	}

	/**
	 * Recupera todos los materiales de la BBDD ordenados por id descendente
	 * 
	 * @return ArrayList<Material> si no existen registros new ArrayList<Material>()
	 */
	public ArrayList<Material> getAll() {

		ArrayList<Material> lista = new ArrayList<Material>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			// Class.forName("com.mysql.jdbc.Driver");
			// final String URL =
			// "jdbc:mysql://192.168.0.42/spoty?user=alumno&password=alumno";
			// con = DriverManager.getConnection(URL);

			con = ConnectionManager.getConnection();

			String sql = "SELECT `id`, `nombre`, `precio` FROM `material`;";

			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();

			Material m = null;
			while (rs.next()) {
				m = new Material();
				m.setId(rs.getInt("id"));
				m.setNombre(rs.getString("nombre"));
				m.setPrecio(rs.getFloat("precio"));
				lista.add(m);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (rs != null) {
					rs.close();
				}

				if (pst != null) {
					pst.close();
				}

				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return lista;
	}

	/**
	 * Muestra listado de elementos que contengan el parametro. Si no encuentra
	 * devuelve null
	 * 
	 * @param search
	 *            Patron de busqueda por nombre
	 * @return Listado
	 */
	public ArrayList<Material> buscarNombre(String search) {
		ArrayList<Material> lista = new ArrayList<Material>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			con = ConnectionManager.getConnection();

			String sql = "SELECT `id`, `nombre`, `precio` FROM `material`" + " WHERE `nombre` LIKE '%" + search
					+ "%'ORDER BY id DESC LIMIT 500;";

			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();

			Material m = null;
			while (rs.next()) {
				m = new Material();
				m.setId(rs.getInt("id"));
				m.setNombre(rs.getString("nombre"));
				m.setPrecio(rs.getFloat("precio"));
				lista.add(m);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (rs != null) {
					rs.close();
				}

				if (pst != null) {
					pst.close();
				}

				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return lista;
	}

	/**
	 * Devuelve un elemento que coincida con el id pasado.<br>
	 * Si no encuentra devuelve null
	 * 
	 * @param id
	 *            Busqueda por id
	 */
	@Override
	public Material getById(int idBuscada) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Material m = null;

		try {
			con = ConnectionManager.getConnection();

			String sql = "SELECT `id`, `nombre`, `precio` FROM `material`" + " WHERE `id` = '" + idBuscada + "';";

			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {
				m = new Material();
				m.setId(rs.getInt("id"));
				m.setNombre(rs.getString("nombre"));
				m.setPrecio(rs.getFloat("precio"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (rs != null) {
					rs.close();
				}

				if (pst != null) {
					pst.close();
				}

				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return m;
	}

	@Override
	public boolean save(Material pojo) {
		Connection con = null;
		PreparedStatement pst = null;
		Material m = null;
		String sql = null;
		boolean resul = false;
		try {
			con = ConnectionManager.getConnection();

			if (pojo.getId() == -1) {
				sql = "INSERT INTO `material` (`nombre`, `precio`) VALUES (?, ?);";
				pst = con.prepareStatement(sql);
				pst.setString(1, pojo.getNombre());
				pst.setFloat(2, pojo.getPrecio());
			} else {
				sql = "UPDATE `material` SET `nombre`='birra' WHERE  `id`=?;";
				pst = con.prepareStatement(sql);
				pst.setInt(1, pojo.getId());
			}

			int affectedRows = pst.executeUpdate();

			if (affectedRows == 1) {
				resul = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (pst != null) {
					pst.close();
				}

				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return false;
	}

	/**
	 * Elimina el elemento de la BD que coincida con la id enviado. <br>
	 * Si no se encuentra devuelve false
	 * 
	 * @param id
	 *            Identificador de elemento que va a borrarse
	 */
	@Override
	public boolean delete(int id) {
		boolean resul = false;
		Connection con = null;
		PreparedStatement pst = null;
		try {

			con = ConnectionManager.getConnection();
			String sql = "DELETE FROM `material` WHERE  `id`= ?;";

			pst = con.prepareStatement(sql);
			pst.setInt(1, id);

			int affectedRows = pst.executeUpdate();

			if (affectedRows == 1) {
				resul = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {

				if (pst != null) {
					pst.close();
				}

				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return resul;
	}

}
