package com.ipartek.formacion.nidea.util;

public class Utilidades {

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
}
