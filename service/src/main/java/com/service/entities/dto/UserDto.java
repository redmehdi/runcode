package com.service.entities.dto;

import com.base.dto.IDto;

/**
 * @author RMehdi
 *
 */
public class UserDto implements IDto {

	private static final long serialVersionUID = 1L;

	private String id;

	private String nombre;

	private String apellido;

	private Long edad;

	private String inscriptionDate;

	private String telefono;

	private String email;

	private String changeBy;

	/**
	 * Construction to retrieve user
	 * 
	 * @param id
	 * @param nombre
	 * @param apellido
	 * @param edad
	 * @param inscriptionDate
	 * @param telefono
	 * @param email
	 * @param changeBy
	 */
	public UserDto(final String id, final String nombre, final String apellido, final Long edad,
			final String inscriptionDate, final String telefono, final String email, final String changeBy) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.inscriptionDate = inscriptionDate;
		this.telefono = telefono;
		this.email = email;
		this.changeBy = changeBy;
	}

	/**
	 * Constructor to store user
	 * 
	 * @param nombre
	 * @param apellido
	 * @param edad
	 * @param inscriptionDate
	 * @param telefono
	 * @param email
	 * @param changeBy
	 */
	public UserDto(final String nombre, final String apellido, final Long edad, final String inscriptionDate,
			final String telefono, final String email, final String changeBy) {
		this(null, nombre, apellido, edad, inscriptionDate, telefono, email, changeBy);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Long getEdad() {
		return edad;
	}

	public String getInscriptionDate() {
		return inscriptionDate;
	}

	public void setInscriptionDate(final String inscriptionDate) {
		this.inscriptionDate = inscriptionDate;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(final String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	public String getChangeBy() {
		return changeBy;
	}

	public void setChangeBy(String changeBy) {
		this.changeBy = changeBy;
	}

	public void setEdad(final Long edad) {
		this.edad = edad;
	}

	@Override
	public String toString() {
		return String.format(
				"UserDto [id=%s, nombre=%s, apellido=%s, edad=%s, inscriptionDate=%s, telefono=%s, email=%s]", id,
				nombre, apellido, edad, inscriptionDate, telefono, email);
	}

}
