package com.CMEPPS.proyectotareas.db_driven_adapter.jparepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.CMEPPS.proyectotareas.db_driven_adapter.domain.TaskEntity;


public interface HAAJpaRepository extends JpaRepository<TaskEntity, Long> {
	
	@Query("SELECT MAX(t.id) FROM TaskEntity t")
    Long getMaxId();
	
	@Query("SELECT t FROM TaskEntity t WHERE t.completada = true")
    List<TaskEntity> findByCompletada();
	
	@Query("SELECT t FROM TaskEntity t WHERE t.idUser = idUser")
    List<TaskEntity> findByUser(Long idUser);
	
}
