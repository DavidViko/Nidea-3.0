package com.ipartek.formacion.nidea.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

public interface Persistible<P> {

	/**
	 * Lista de una taba de la base de datos ordenados por id descendente y limitado
	 * a 500
	 * 
	 * @return Coleccion
	 */
	public ArrayList<P> getAll();

	/**
	 * Obtenemos el detalle de un registro
	 * 
	 * @param id
	 *            Identificador
	 * @return Registro si existe, null en caso contrario
	 */
	public P getById(int id);

	/**
	 * Guardamos un registro en la BD <br>
	 * Si el id del pojo ==-1 Creamos <br>
	 * Si el id del Pojo > -1 Modificamos
	 * 
	 * @param pojo
	 * @return
	 * @throws SQLIntegrityConstraintViolationException
	 */
	public boolean save(P pojo) throws SQLIntegrityConstraintViolationException;

	/**
	 * Eliminamos un registro por su identificador
	 * 
	 * @param id
	 * @return
	 */
	public boolean delete(int id);

	/**
	 * Nos mapea el resultado de la BBDD a un Pojo
	 * 
	 * @param rs
	 *            ResultSet 1 registro de la consulta
	 * @return Pojo con los valores del ResultSet o null si no hay valores
	 */
	public P mapper(ResultSet rs) throws SQLException;
}
