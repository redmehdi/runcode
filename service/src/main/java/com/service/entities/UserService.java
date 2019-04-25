package com.service.entities;

import java.util.List;

import com.base.service.IService;
import com.persistence.entities.impl.UserEntity;
import com.service.entities.dto.UserDto;

public interface UserService extends IService<UserEntity, UserDto>{
	
	List<UserDto> findByApellido(String apellido);

	List<UserDto> findByEmail(String email);

}
