package com.ipartek.formacion.nidea.debug;

public class Main {
	public static void main(String[] args) {
		System.out.println("Metodo main");

		metodoA();

		for (int i = 1; i < 5000; i++) {
			System.out.println("Iteracion: " + i);
		}
	}

	private static void metodoA() {
		System.out.println("Entra de metodo A");
		metodoB();
		System.out.println("Sale de metodo A");
	}

	private static void metodoB() {
		System.out.println("Entra de metodo B");
		metodoC();
		System.out.println("Sale de metodo B");
	}

	private static void metodoC() {
		System.out.println("Entra de metodo C");
		String fecha = Utilidades.diaHoy();
		System.out.println(fecha);
		System.out.println("Sale de metodo C");
	}
}
