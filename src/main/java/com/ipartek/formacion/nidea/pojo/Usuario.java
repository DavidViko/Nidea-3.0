package com.ipartek.formacion.nidea.pojo;

public class Usuario {
	private int id;
	private String nombre;
	private String password;
	private Rol rol;

	public Usuario() {
		super();
		this.id = -1;
		this.nombre = "";
		this.password = "";
		rol = new Rol();
	}

	public Usuario(String nombre, String password) {
		this();
		this.id = id;
		this.nombre = nombre;
		this.password = password;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", password=" + password + ", rol=" + rol + "]";
	}
}
