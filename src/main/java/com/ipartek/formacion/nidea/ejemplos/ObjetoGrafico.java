package com.ipartek.formacion.nidea.ejemplos;

public abstract class ObjetoGrafico implements Imprimible {
	int x, y;

	void moverA(int x, int y) {
		this.x = x;
		this.y = y;
		System.out.println("Mover Objeto grafico");
	}

	abstract void dibujar();

	public ObjetoGrafico() {
		super();
		this.x = 0;
		this.y = 0;
	}

	@Override
	public String toString() {
		return "ObjetoGrafico [x=" + x + ", y=" + y + "]";
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}
