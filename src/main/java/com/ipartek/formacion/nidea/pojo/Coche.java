package com.ipartek.formacion.nidea.pojo;

public class Coche implements AutoCloseable {

	public Coche() {
		super();
		System.out.println("Creamos coche");
	}

	public void conducir() {
		System.out.println("Brum brum");
	}

	@Override
	public void close() throws Exception {
		System.out.println("Paramos coche");
	}

	public static void main(String[] args) {
		// A PARTIR DE JAVA7
		// si declaramos un objeto que implemete la interfaz Autocloseable
		// dentro de los parentesis del TRY, cuando acaba el TRY se ejecuta
		// de forma automatica su metodo close()

		try (Coche c = new Coche()) {
			System.out.println("Empezo programa");
			c.conducir();
		} catch (Exception e) {
			System.out.println("Tenemos una excepcion");
		} finally {
			System.out.println("Finalizamos");
		}
	}
}
