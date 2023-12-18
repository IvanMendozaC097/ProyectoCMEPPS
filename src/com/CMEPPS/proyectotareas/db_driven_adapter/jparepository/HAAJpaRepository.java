package com.CMEPPS.proyectotareas.db_driven_adapter.jparepository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.CMEPPS.proyectotareas.db_driven_adapter.domain.TaskEntity;

public interface HAAJpaRepository extends JpaRepository<TaskEntity, Long> {

	@Query("SELECT COALESCE(MAX(t.id), 0) FROM TaskEntity t")
	Long getMaxId();

	@Query("SELECT t FROM TaskEntity t WHERE t.completada = true AND t.idUser = idUser")
	List<TaskEntity> findByCompletada(@Param("idUser") Long idUser);

	@Query("SELECT t FROM TaskEntity t WHERE t.idUser = idUser")
	List<TaskEntity> findByUser(@Param("idUser") Long idUser);

	@Query("SELECT t FROM TaskEntity t WHERE t.semana = 0")
	List<TaskEntity> findByNoPlan();

	@Query("SELECT t FROM TaskEntity t WHERE t.semana = :semana AND t.mes = :mes AND t.anio = :anio AND t.completada = false")
	List<TaskEntity> findBysemana(@Param("semana") int semana, @Param("mes") int mes, @Param("anio") int anio);

	@Query("SELECT t FROM TaskEntity t WHERE t.id = :id")
	Optional<TaskEntity> findById(@Param("id") Long id);

}
