package com.ipartek.formacion.nidea.debug;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utilidades {

	public static String diaHoy() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
		Date date = new Date();
		String dateString = sdf.format(date);
		String fecha = dateString;

		return fecha;
	}

}
