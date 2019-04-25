package com.persistence.entities.respository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.base.repository.IRepository;
import com.persistence.entities.impl.UserEntity;

public interface UserRepository extends IRepository<UserEntity, Long> {

	List<UserEntity> findByApellido(String apellido);

	@Query("select u from UserEntity u INNER JOIN FETCH u.contact c where c.email = :email")
	List<UserEntity> findByEmail(@Param("email") String email);

}
