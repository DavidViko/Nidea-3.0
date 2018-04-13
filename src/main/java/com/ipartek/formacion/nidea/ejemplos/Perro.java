package com.ipartek.formacion.nidea.ejemplos;

public class Perro implements Ordenable {
	private int vacunas;

	public Perro() {
		super();
		vacunas = 0;
	}

	public int getVacunas() {
		return vacunas;
	}

	public void setVacunas(int vacunas) {
		this.vacunas = vacunas;
	}

	@Override
	public int getValor() {
		return getVacunas();
	}
}
