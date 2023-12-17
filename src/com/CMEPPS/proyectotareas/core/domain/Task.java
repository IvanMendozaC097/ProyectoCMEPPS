package com.CMEPPS.proyectotareas.core.domain;

public class Task {
	private Long id;
	private String nombre;
	private String descripcion;
	private float tiempoEstimado;
	private int prioridad;
	private Long idUser;
	private Boolean completada;
	private Integer semana;
	private Integer mes;
	private Integer anio;
	

	public Task(Long id, String nombre, String descripcion, float tiempoEstimado, int prioridad, Long idUser,
			Boolean completada, int semana, int mes, int anio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.tiempoEstimado = tiempoEstimado;
		this.prioridad = prioridad;
		this.idUser = idUser;
		this.completada = completada;
		this.semana = semana;
		this.mes = mes;
		this.anio = anio;
	}



	public Boolean getCompletada() {
		return completada;
	}
	
	public void setCompletada(Boolean completada) {
		this.completada = completada;
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

	public Integer getSemana() {
		return semana;
	}

	public void setSemana(Integer semana) {
		this.semana = semana;
	}

	public Integer getMes() {
		return mes;
	}

	public void setMes(Integer mes) {
		this.mes = mes;
	}

	public Integer getAnio() {
		return anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}
	
	
	
	
	
}
