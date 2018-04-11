package com.ipartek.formacion.nidea.ejemplos;

public class Circulo extends ObjetoGrafico {
	int radio;

	@Override
	void dibujar() {

	}

	public Circulo() {
		super();
		this.radio = 0;
	}

	@Override
	public void imprimir() {
		System.out.println("Imprime circulo");

	}

}
