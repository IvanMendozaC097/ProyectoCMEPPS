package com.CMEPPS.proyectotareas.db_driven_adapter.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.CMEPPS.proyectotareas.core.domain.Task;
import com.CMEPPS.proyectotareas.core.domain.User;

@Entity
public class TaskEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "descripcion")
	private String descripcion;
	@Column(name = "tiempoEstimado")
	private float tiempoEstimado;
	@Column(name = "prioridad")
	private int prioridad;
	@Column(name = "idUser")
	private Long idUser;
	@Column(name = "completada")
	private Boolean completada;
	@Column(name = "semana")
	private int semana;
	@Column(name = "mes")
	private int mes;
	@Column(name = "anio")
	private int anio;

	public TaskEntity(Task task) {
		super();
		this.id = task.getId();
		this.nombre = task.getNombre();
		this.descripcion = task.getDescripcion();
		this.tiempoEstimado = task.getTiempoEstimado();
		this.prioridad = task.getPrioridad();
		this.idUser = task.getUser();
		this.completada = task.getCompletada();
		this.semana = task.getSemana();
		this.mes = task.getMes();
		this.anio = task.getAnio();
	}

	public TaskEntity() {
	}

	public Task toTask() {
		return new Task(this.id, this.nombre, this.descripcion, this.tiempoEstimado, this.prioridad, this.idUser,
				this.completada, this.semana, this.mes, this.anio);
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

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public boolean isCompletada() {
		return completada;
	}

	public void setCompletada(boolean completada) {
		this.completada = completada;
	}

	public int getSemana() {
		return semana;
	}

	public void setSemana(int semana) {
		this.semana = semana;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}
	
	

}
