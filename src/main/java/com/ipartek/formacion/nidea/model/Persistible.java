package com.ipartek.formacion.nidea.model;

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
	 */
	public boolean save(P pojo);

	/**
	 * Eliminamos un registro por su identificador
	 * 
	 * @param id
	 * @return
	 */
	public boolean delete(int id);
}
