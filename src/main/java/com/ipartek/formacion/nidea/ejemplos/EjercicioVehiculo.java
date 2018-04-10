package com.ipartek.formacion.nidea.ejemplos;

public class EjercicioVehiculo {

	public static void main(String[] args) {
		// Vehiculo rayoMcQueen = new Vehiculo();
		// No se pueden crear objetods de una clase abstracta
		// System.out.println(rayoMcQueen.toString());
		System.out.println("------------");
		VehiculoElectrico tesla = new VehiculoElectrico();
		System.out.println(tesla);

		System.out.println(tesla.getColor());
	}
}
