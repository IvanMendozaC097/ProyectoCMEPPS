package com.CMEPPS.proyectotareas.core.driver_ports;

import java.util.List;

import com.CMEPPS.proyectotareas.core.domain.Task;

public interface TaskService {
	public Long guardarTarea(String nombre, String descripcion, float tiempoEstimado, int prioridad, Long idUser,
			boolean completada,int semana, int mes, int año);

	public Task getTask(Long id);

	public List<Task> listarTareas(Long idUser);

	public List<Task> listarCompletadas(Long idUser);

	public void borrar(Long id);
	
	public void actualizarTask(Task task);
	
	public List<Task> TareasSinPlanificar();
	
	public List<Task> TareasDeLaSemana(int semana,int mes,int anio);

}
