package com.CMEPPS.proyectotareas.db_driven_adapter;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.CMEPPS.proyectotareas.core.domain.User;
import com.CMEPPS.proyectotareas.core.domain.UserDoesNotExistException;
import com.CMEPPS.proyectotareas.core.driven_ports.UserRepository;
import com.CMEPPS.proyectotareas.db_driven_adapter.domain.UserEntity;
import com.CMEPPS.proyectotareas.db_driven_adapter.jparepository.HAAJpaRepository;
import com.CMEPPS.proyectotareas.db_driven_adapter.jparepository.HAAJpaUserRepository;

@Component
public class JpaUserRepository implements UserRepository{
	@Autowired
	private HAAJpaUserRepository haaJpaUserRepository;
	
	@Override
	public User findById(Long id) {
		Optional<UserEntity> userEntityOptional = haaJpaUserRepository.findById(id);
		UserEntity userEntity = userEntityOptional.orElseThrow(UserDoesNotExistException::new);
		return ((UserEntity) userEntity).toUser();
	}

	@Override
	public void actualizar(User user) {
		UserEntity userEntity = new UserEntity(user);
		userEntity.setDisponibilidad(user.getDisponibilidad());
		userEntity.setEmail(user.getEmail());
		userEntity.setNombre(user.getNombre());
		userEntity.setPassword(user.getPassword());
		haaJpaUserRepository.save(userEntity);
	}

	@Override
	public void guardar(User user) {
		UserEntity userEntity = new UserEntity(user);
		haaJpaUserRepository.save(userEntity);
	}

	@Override
	public void borrar(Long id) {
		Optional<UserEntity> userEntity = haaJpaUserRepository.findById(id);
		haaJpaUserRepository.delete(userEntity.get());
		
	}

	@Override
	public List<User> obtenerUsuario(Long id) {
		List<UserEntity> userEntity = haaJpaUserRepository.findUserById(id);
		
		return userEntity.stream().map(UserEntity::toUser).collect(Collectors.toList());
	}
}
