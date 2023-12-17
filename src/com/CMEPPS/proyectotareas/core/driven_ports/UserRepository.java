package com.CMEPPS.proyectotareas.core.driven_ports;

import java.util.List;

import com.CMEPPS.proyectotareas.core.domain.User;

public interface UserRepository {
	User findById(Long id);
	
	public List<User> obtenerUsuario(Long id);
	
	public void actualizar(User user);
	
	public void guardar(User user);
	
	public void borrar(Long id);
}

