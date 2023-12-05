package com.CMEPPS.proyectotareas.core.domain;

public class Task {
	private Long id;
	private String nombre;
	private String descripcion;
	private float tiempoEstimado;
	private int prioridad;
	private User user;
	
	public Task(Long id, String nombre, String descripcion, float tiempoEstimado, int prioridad, User user) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.tiempoEstimado = tiempoEstimado;
		this.prioridad = prioridad;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getTiempoEstimado() {
		return tiempoEstimado;
	}

	public void setTiempoEstimado(float tiempoEstimado) {
		this.tiempoEstimado = tiempoEstimado;
	}

	public int getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(int prioridad) {
		this.prioridad = prioridad;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}
