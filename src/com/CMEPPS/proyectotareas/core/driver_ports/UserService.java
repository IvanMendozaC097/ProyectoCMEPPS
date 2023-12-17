package com.CMEPPS.proyectotareas.core.driver_ports;

import java.util.List;

import com.CMEPPS.proyectotareas.core.domain.User;

public interface UserService {
	
	public Long guardarUsuario(String email, String password, int disponibilidad, String nombre);
	
	User getUser(Long id);
	
	public List<User> listarUsuario(Long id);
	
	public void actualizarUser(User user);

	public void borrar(Long id);
}
