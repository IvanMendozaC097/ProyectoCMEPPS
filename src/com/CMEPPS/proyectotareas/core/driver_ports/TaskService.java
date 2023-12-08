package com.CMEPPS.proyectotareas.core.driver_ports;

import java.util.List;

import com.CMEPPS.proyectotareas.core.domain.Task;

public interface TaskService {
	public Long guardarTarea(String nombre, String descripcion, float tiempoEstimado, int prioridad, Long idUser, boolean completada);
	public Task getTask(Long id);
	public List<Task> listarTareas(Long idUser);
	public List<Task> listarCompletadas(Long idUser);
}

