package com.CMEPPS.proyectotareas.core.driver_ports;

import java.util.List;
import java.util.Optional;

import com.CMEPPS.proyectotareas.core.domain.Task;
import com.CMEPPS.proyectotareas.core.driven_ports.TaskRepository;
import com.CMEPPS.proyectotareas.db_driven_adapter.domain.TaskEntity;

public class TaskServiceImpl implements TaskService {

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
	public Long guardarTarea(String nombre, String descripcion, float tiempoEstimado, int prioridad, Long idUser,
			boolean completada) {
		Long idTask = taskRepository.obtenerSiguienteCodigo();

		Task task = new Task(idTask, nombre, descripcion, tiempoEstimado, prioridad, idUser, completada);

		this.taskRepository.guardar(task);

		return idTask;
	}

	@Override
	public List<Task> listarTareas(Long idUser) {
		List<Task> todasTareas = this.taskRepository.obtenerTodas(idUser);
		return todasTareas;
	}

	public List<Task> listarCompletadas(Long idUser) {
		List<Task> tareasCompletadas = this.taskRepository.obtenerCompletadas(idUser);
		return tareasCompletadas;
	}

	@Override
	public void ActualizarTarea(Task tarea) {
		this.taskRepository.guardar(tarea);

	}

	@Override
	public void borrar(Long id) {
		taskRepository.borrar(id);
	}

}
