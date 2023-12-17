package com.CMEPPS.proyectotareas.core.driver_ports;

import java.util.List;

import com.CMEPPS.proyectotareas.core.domain.User;
import com.CMEPPS.proyectotareas.core.driven_ports.UserRepository;

public class UserServiceImpl implements UserService{

	private UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
	}
	
	@Override
	public User getUser(Long id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id);
	}

	@Override
	public void actualizarUser(User user) {
		this.userRepository.actualizar(user);
	}

	@Override
	public void borrar(Long id) {
		userRepository.borrar(id);
	}

	@Override
	public List<User> listarUsuario(Long id) {
		List<User> usuario = this.userRepository.obtenerUsuario(id);
		return usuario;
	}

	@Override
	public Long guardarUsuario(String email, String password, int disponibilidad, String nombre) {
		Long id = (long) 1;
		User user = new User(id, email, password, disponibilidad,nombre);
		this.userRepository.guardar(user);
		return id;
	}

}
