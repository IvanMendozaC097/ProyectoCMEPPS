package com.CMEPPS.proyectotareas.db_driven_adapter.jparepository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.CMEPPS.proyectotareas.db_driven_adapter.domain.UserEntity;

public interface HAAJpaUserRepository extends JpaRepository<UserEntity, Long>{

	@Query("SELECT u FROM UserEntity u WHERE u.id = :id")
	Optional<UserEntity> findById(@Param("id") Long id);
	
	@Query("SELECT u FROM UserEntity u WHERE u.id = id")
	List<UserEntity> findUserById(@Param("id") Long id);
}
