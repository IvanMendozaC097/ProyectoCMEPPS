package com.CMEPPS.proyectotareas.core.driver_ports;

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

}
