package com.CMEPPS.proyectotareas.db_driven_adapter.jparepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.CMEPPS.proyectotareas.db_driven_adapter.domain.TaskEntity;


public interface HAAJpaRepository extends JpaRepository<TaskEntity, Long> {
	
	@Query("SELECT MAX(t.id) FROM TaskEntity t")
    Long getMaxId();
}
