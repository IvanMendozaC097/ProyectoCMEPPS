package com.CMEPPS.proyectotareas.core.driver_ports;

import java.util.List;

import com.CMEPPS.proyectotareas.core.domain.Task;
import com.CMEPPS.proyectotareas.core.driven_ports.TaskRepository;

public class TaskServiceImpl implements TaskService{

	private TaskRepository taskRepository;
	
	public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
	}
	
	@Override
	public Task getTask(Long id) {
		// TODO Auto-generated method stub
		return taskRepository.findById(id);
	}

	@Override
	public Long guardarTarea(String nombre, String descripcion, float tiempoEstimado, int prioridad, Long idUser, boolean completada) {
		Long idTask = taskRepository.obtenerSiguienteCodigo();
		
		Task task = new Task(idTask, nombre, descripcion, tiempoEstimado, prioridad, idUser, completada);
		
		this.taskRepository.guardar(task);
		
		return idTask;
	}

	private List<Task> listarTareas() {
        List<Task> todasTareas = this.taskRepository.obtenerTodas();
        return todasTareas;
    }
	
	private List<Task> listarCompletadas(){
		List<Task> tareasCompletadas = this.taskRepository.obtenerCompletadas();
		return tareasCompletadas;
	}
	
}
