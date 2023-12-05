package com.CMEPPS.proyectotareas.core.driven_ports;

import com.CMEPPS.proyectotareas.core.domain.User;

public interface UserRepository {
	User findById(Long id);
}

