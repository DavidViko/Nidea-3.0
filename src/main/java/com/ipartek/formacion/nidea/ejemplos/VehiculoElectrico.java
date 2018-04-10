package com.ipartek.formacion.nidea.ejemplos;

public class VehiculoElectrico extends Vehiculo {
	private float potencia; // Kw

	public VehiculoElectrico() {
		super();

		this.potencia = 0;
		System.out.println("Instanciado vehiculo electrico");
	}

	public VehiculoElectrico(float potencia) {
		this();// cambiar super por this para que llame al contructor padre de esta clase, que
				// a su vez llama al padre
		this.potencia = potencia;
	}

	@Override
	public void arrancar() {
		// super.arrancar();
		System.out.println("Pulsar boton encendido");
	}

	@Override
	public String toString() {
		return super.toString() + "VehiculoElectrico [potencia=" + potencia + "]";
	}

	public float getPotencia() {
		return potencia;
	}

	public void setPotencia(float potencia) {
		this.potencia = potencia;
	}

}
