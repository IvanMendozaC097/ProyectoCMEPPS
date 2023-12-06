package com.CMEPPS.proyectotareas.core.driver_ports;

import com.CMEPPS.proyectotareas.core.domain.Task;

public interface TaskService {
	public Long guardarTarea(String nombre, String descripcion, float tiempoEstimado, int prioridad, Long idUser);
	public Task getTask(Long id);
}
