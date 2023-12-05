package com.CMEPPS.proyectotareas.core.domain;

public class User {

	private Long id;
	private String email;
	private String password;
	private int disponibilidad;
	private String nombre;
	
	public User(Long id, String email, String password, int disponibilidad, String nombre) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.disponibilidad = disponibilidad;
		this.nombre = nombre;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getDisponibilidad() {
		return disponibilidad;
	}
	public void setDisponibilidad(int disponibilidad) {
		this.disponibilidad = disponibilidad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
	
	
	
}
