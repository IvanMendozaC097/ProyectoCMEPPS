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
public class JpaTaskRepository implements TaskRepository {
	@Autowired
	private HAAJpaRepository haaJpaRepository;

	@Override
	public Task findById(Long id) {
		Optional<TaskEntity> taskEntityOptional = haaJpaRepository.findById(id);
		TaskEntity taskEntity = taskEntityOptional.orElseThrow(TaskDoesNotExistException::new);
		return ((TaskEntity) taskEntity).toTask();
	}

	@Override
	public List<Task> obtenerTodas(Long idUser) {
		List<TaskEntity> taskEntities = haaJpaRepository.findByUser(idUser);
		return taskEntities.stream().map(TaskEntity::toTask).collect(Collectors.toList());
	}

	@Override
	public List<Task> obtenerCompletadas(Long idUser) {
		List<TaskEntity> completadasEntities = haaJpaRepository.findByCompletada(idUser);
		return completadasEntities.stream().map(TaskEntity::toTask).collect(Collectors.toList());
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
	
	@Override
	public void borrar(Long id) {
		Optional<TaskEntity> taskEntity = haaJpaRepository.findById(id);
		haaJpaRepository.delete(taskEntity.get());

	}

	@Override
	public void actualizar(Task task) {
		TaskEntity taskEntity = new TaskEntity(task);
		
		taskEntity.setDescripcion(task.getDescripcion());
		taskEntity.setNombre(task.getNombre());
		taskEntity.setPrioridad(task.getPrioridad());
		taskEntity.setTiempoEstimado(task.getTiempoEstimado());
		taskEntity.setCompletada(task.getCompletada());
		taskEntity.setSemana(task.getSemana());
		taskEntity.setMes(task.getMes());
		taskEntity.setAnio(task.getAnio());
		
		haaJpaRepository.save(taskEntity);
		
	}

	@Override
	public List<Task> obtenerSinPlanificar() {
		List<TaskEntity> taskEntities = haaJpaRepository.findByNoPlan();
		return taskEntities.stream().map(TaskEntity::toTask).collect(Collectors.toList());
	}

	@Override
	public List<Task> obtenerTareasSemana(int semana, int mes, int anio) {
		List<TaskEntity> taskEntities = haaJpaRepository.findBysemana(semana,mes,anio);
		return taskEntities.stream().map(TaskEntity::toTask).collect(Collectors.toList());
	}



}
