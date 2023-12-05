package com.CMEPPS.proyectotareas.db_driven_adapter.jparepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CMEPPS.proyectotareas.db_driven_adapter.domain.TaskEntity;


public interface HAAJpaRepository extends JpaRepository<TaskEntity, Long> {}
