package com.rest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.service.converter.UserConverter;
import com.service.entities.UserService;
import com.service.entities.dto.UserDto;

/**
 * Controller class for user operation
 * 
 * @author RMehdi
 *
 */
@RestController
@ComponentScan("com.*")
public class UserController {

	private static final Logger log = LoggerFactory.getLogger(UserConverter.class);

	@Autowired
	private final UserService service;

	public UserController(UserService service) {
		this.service = service;
	}

	@RequestMapping("/user")
	public List<UserDto> getUser(@RequestParam(value = "email", defaultValue = "") String email) {
		return service.findByEmail(email);
	}

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/add")
	public @ResponseStatus(value = HttpStatus.CREATED) ResponseEntity<String> newUser(@Valid @RequestBody UserDtoRequest user) {

		UserDto userR = new UserDto(user.getNombre(), user.getApellido(), user.getEdad(), user.getInscriptionDate(),
				user.getTelefono(), user.getEmail(), user.getChangeBy());
		boolean userDto = service.addOrUpdate(userR);
		log.info("The user is registed: " + user.getEmail());
		return ResponseEntity.ok("User is valid");

	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(
	  MethodArgumentNotValidException ex) {
	    Map<String, String> errors = new HashMap<>();
	    ex.getBindingResult().getAllErrors().forEach((error) -> {
	        String fieldName = ((FieldError) error).getField();
	        String errorMessage = error.getDefaultMessage();
	        errors.put(fieldName, errorMessage);
	    });
	    return errors;
	}

}
