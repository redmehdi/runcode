package com.service.entities;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.converter.BaseConverter;
import com.base.service.BaseService;
import com.persistence.entities.impl.UserEntity;
import com.persistence.entities.respository.UserRepository;
import com.service.converter.UserConverter;
import com.service.entities.dto.UserDto;

@Service
public class UserServiceImpl extends BaseService<UserEntity, UserDto, UserRepository> implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	protected BaseConverter<UserEntity, UserDto> getConverter() {
		return new UserConverter();
	}

	@Override
	public List<UserDto> findByApellido(String apellido) {
		return getConverter().getDtos(userRepository.findByApellido(apellido));
	}

	@Override
	public List<UserDto> findByEmail(String email) {
		return getConverter().getDtos(userRepository.findByEmail(email));
	}

}
