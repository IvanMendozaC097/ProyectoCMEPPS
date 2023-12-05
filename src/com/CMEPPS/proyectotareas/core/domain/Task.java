package com.CMEPPS.proyectotareas.core.domain;

public class Task {
	private Long id;
	private String nombre;
	private String descripcion;
	private float tiempoEstimado;
	private int prioridad;
	private Long idUser;
	
	public Task(Long id, String nombre, String descripcion, float tiempoEstimado, int prioridad, Long idUser) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.tiempoEstimado = tiempoEstimado;
		this.prioridad = prioridad;
		this.idUser = idUser;
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

	public Long getUser() {
		return idUser;
	}

	public void setUser(Long idUser) {
		this.idUser = idUser;
	}
	
	
	
}
