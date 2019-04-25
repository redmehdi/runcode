package com.rest.controller.exception;

import com.service.entities.dto.UserDto;

public class UserDataException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UserDataException(UserDto user) {
		super("Cannot store the user due to incorrected data:" + user.toString());
	}
}
