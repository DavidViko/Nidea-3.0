package com.ipartek.formacion.nidea.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ipartek.formacion.nidea.ejemplos.Ordenable;

public class Utilidades {

	/**
	 * Devuelve la fecha del dia presente con formato dd/M/yyyy
	 * 
	 * @return fecha de tipo String
	 */
	public static String diaHoy() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
		Date date = new Date();
		String dateString = sdf.format(date);
		String fecha = dateString;

		return fecha;
	}

	/**
	 * Metodo estatico para poder usarse desde la propia Clase, sin tener que
	 * instanciar un objeto<br>
	 * Limpia los caracteres en blanco de una cadena String <br>
	 * Hacemos trim y sustituir todos los espacios en blanco por uno unico. Ej:<br>
	 * " hola que hace " => "hola que hace"<br>
	 * 
	 * @param cadena
	 * @return en caso de null retorna cadena vacia ""
	 */
	public static String limpiarEspacios(String cadena) {
		String cadenaLimpia = "";
		if (cadena != null) {
			cadenaLimpia = cadena.replaceAll(" +", " ").trim();
		}
		return cadenaLimpia;
	}

	/**
	 * Ordena una coleccion con el algoritmo de bubbleSort. Ordena de menor a mayor,
	 * basandose en el metodo getValor de la interface Ordenable
	 * 
	 * @see com.ipartek.formacion.nidea.ejemplos.Ordenable
	 * @param coleccion
	 *            List<Ordenable> coleccion con los elementos a ordenar
	 * @return Coleccion ordenada. En caso de null, retorna una lista vacia
	 */
	public static List<Ordenable> bubbleSort(List<Ordenable> coleccion) {
		List<Ordenable> resul = new ArrayList<Ordenable>();
		if (coleccion != null) {
			Ordenable auxiliar;
			for (int i = 0; i < coleccion.size() - 1; i++) {
				for (int j = 0; j < coleccion.size() - 1 - i; j++) {
					if (coleccion.get(j).getValor() > coleccion.get(j + 1).getValor()) {
						auxiliar = coleccion.get(j);
						coleccion.set(j, coleccion.get(j + 1));
						coleccion.set((j + 1), auxiliar);
					}
				}
			}
			resul = coleccion;
		}
		return resul;
	}
}
