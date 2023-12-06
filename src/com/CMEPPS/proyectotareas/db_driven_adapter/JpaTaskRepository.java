package com.CMEPPS.proyectotareas.db_driven_adapter;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.CMEPPS.proyectotareas.core.domain.Task;
import com.CMEPPS.proyectotareas.core.domain.TaskDoesNotExistException;
import com.CMEPPS.proyectotareas.core.driven_ports.TaskRepository;
import com.CMEPPS.proyectotareas.db_driven_adapter.domain.TaskEntity;
import com.CMEPPS.proyectotareas.db_driven_adapter.jparepository.HAAJpaRepository;

@Component
public class JpaTaskRepository implements TaskRepository{
	@Autowired
	private HAAJpaRepository haaJpaRepository;
	
	@Override
	public Task findById(Long id) {
		Optional<TaskEntity> taskEntityOptional = haaJpaRepository.findById(id);
		Entity taskEntity = (Entity) taskEntityOptional.orElseThrow(TaskDoesNotExistException::new);
		return  ((TaskEntity) taskEntity).toTask();
	}

	@Override
	public List<Task> obtenerTodas() {
	    List<TaskEntity> taskEntities = haaJpaRepository.findAll();
	    return taskEntities.stream()
	            .map(TaskEntity::toTask)
	            .collect(Collectors.toList());
	}

	@Override
	public Long obtenerSiguienteCodigo() {
	    Long maxId = haaJpaRepository.getMaxId(); 
	    return maxId != null ? maxId + 1 : 1L; // Si no hay registros, devuelve 1 como el primer código
	}

	@Override
	public void guardar(Task task) {
		 TaskEntity taskEntity = new TaskEntity(task);
		 haaJpaRepository.save(taskEntity);
		
	}

}