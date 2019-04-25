package com.service.converter;

import java.text.ParseException;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;

import com.base.converter.BaseConverter;
import com.base.util.UtilProcess;
import com.persistence.entities.impl.ContactEntity;
import com.persistence.entities.impl.UserEntity;
import com.service.entities.dto.UserDto;

/**
 * @author RMehdi
 * 
 *
 */
@ComponentScan({ "com.*" })
public final class UserConverter extends BaseConverter<UserEntity, UserDto> {

	private static final Logger log = LoggerFactory.getLogger(UserConverter.class);

	@Override
	public UserDto getDto(UserEntity e) {
		final ContactEntity contacto = e.getContact();
		final String nombre = e.getNombre();
		final String apellido = e.getApellido();
		final Long edad = e.getEdad();
		final Date inscriptionDate = e.getInscriptionDate();
		final String modifiedNameBy = e.getModifiedNameBy();
		
		String email = null;
		String telefono = null;
		if (contacto != null) {
			telefono = contacto.getTelefono();
			email = contacto.getEmail();
		}

		log.debug("create new user: " + apellido);
		return new UserDto(e.getIdExt(), nombre, apellido, edad, inscriptionDate.toString(), telefono, email,
				modifiedNameBy);
	}

	@Override
	public UserEntity getEntity(UserDto t) {
		log.debug("create new user" + t.getEmail());
		final String nombre = t.getNombre();
		final String apellido = t.getApellido();
		final String telefono = t.getTelefono();
		final Long edad = t.getEdad();
		final String modifiedNameBy = t.getChangeBy();
		String email = t.getEmail();
		Date inscriptionDate = null;

		try {
			inscriptionDate = UtilProcess.stringToDate(t.getInscriptionDate());
		} catch (ParseException e) {
		}

		final ContactEntity contact = t.getId() == null
				? new ContactEntity(modifiedNameBy, modifiedNameBy, telefono, email)
				: new ContactEntity(modifiedNameBy, telefono, email);

		return t.getId() == null
				? new UserEntity(modifiedNameBy, modifiedNameBy, contact, nombre, apellido, edad, inscriptionDate)
				: new UserEntity(modifiedNameBy, contact, nombre, apellido, edad, inscriptionDate);
	}

}
