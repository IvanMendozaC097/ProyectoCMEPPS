package com.CMEPPS.proyectotareas.db_driven_adapter.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import com.CMEPPS.proyectotareas.core.domain.User;

@Entity
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "email")
	private String email;
	@Column(name = "password")
	private String password;
	@Column(name = "disponibilidad")
	private int disponibilidad;
	@Column(name = "nombre")
	private String nombre;

	public UserEntity(User u) {
		super();
		this.id = u.getId();
		this.email = u.getEmail();
		this.password = u.getPassword();
		this.disponibilidad = u.getDisponibilidad();
		this.nombre = u.getNombre();
	}

	public User toUser() {
		return new User(this.id, this.email, this.password, this.disponibilidad, this.nombre);
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
