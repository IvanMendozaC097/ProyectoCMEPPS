package com.CMEPPS.proyectotareas.core.driven_ports;

import java.util.List;
import com.CMEPPS.proyectotareas.core.domain.Task;

public interface TaskRepository {
	public Task findById(Long id);

	public List<Task> obtenerTodas(Long idUser);

	public List<Task> obtenerCompletadas(Long idUser);

	public Long obtenerSiguienteCodigo();

	public void guardar(Task task);
	
	public void actualizar(Task task);

	public void borrar(Long id);

}
