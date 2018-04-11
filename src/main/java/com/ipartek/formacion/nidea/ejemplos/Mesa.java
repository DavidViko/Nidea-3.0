package com.ipartek.formacion.nidea.ejemplos;

public class Mesa implements Ordenable {
	private int patas;

	public Mesa() {
		super();
		patas = 0;
	}

	public int getPatas() {
		return patas;
	}

	public void setPatas(int patas) {
		this.patas = patas;
	}

	@Override
	public int getValor() {
		return getPatas();
	}
}
