package com.CMEPPS.proyectotareas.core.driven_ports;

import com.CMEPPS.proyectotareas.core.domain.Task;

public interface TaskRepository {
	Task findById(Long id);
}
