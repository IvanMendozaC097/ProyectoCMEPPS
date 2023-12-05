package com.CMEPPS.proyectotareas.core.driver_ports;

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

}
