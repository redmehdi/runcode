package com.rest.controller;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

import com.base.util.UtilProcess;
import com.fasterxml.jackson.annotation.JsonSetter;

/**
 * @author RMehdi
 *
 */
public class UserDtoRequest {
	
	@NotBlank(message="Name cannot be empty")
	private String nombre;

	@NotBlank(message="Second name cannot be empty")
	private String apellido;

	@NotNull(message="Age cannot be empty")
	@Min(value = 18, message = "Age should be equal or more than 18")
	@Positive(message="Age should not be negative")
	private Long edad;

	private String inscriptionDate;

	@Pattern(regexp = UtilProcess.PHONE_REGEX,message="must be correct number phone ex: (0034/+34) 600000000")
	private String telefono;

	@Pattern(regexp = UtilProcess.EMAIL_REGEX,message="must be correct email ex: redouane@service.ma")
	private String email;

	private String changeBy;

	public String getNombre() {
		return nombre;
	}

	@JsonSetter("Nombre")
	public void setNombreUpper(String nombre) {
	    this.nombre = nombre;
	}
	@JsonSetter("nombre")
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	@JsonSetter("apellido")
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	@JsonSetter("Apellido")
	public void setApellidoUpper(String apellido) {
		this.apellido = apellido;
	}

	public Long getEdad() {
		return edad;
	}

	@JsonSetter("edad")
	public void setEdad(Long edad) {
		this.edad = edad;
	}
	
	@JsonSetter("Edad")
	public void setEdadUpper(Long edad) {
		this.edad = edad;
	}

	public String getInscriptionDate() {
		return inscriptionDate;
	}

	@JsonSetter("inscriptionDate")
	public void setInscriptionDate(String inscriptionDate) {
		this.inscriptionDate = inscriptionDate;
	}
	
	@JsonSetter("InscriptionDate")
	public void setInscriptionDateUpper(String inscriptionDate) {
		this.inscriptionDate = inscriptionDate;
	}

	public String getTelefono() {
		return telefono;
	}

	@JsonSetter("telefono")
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	@JsonSetter("Telefono")
	public void setTelefonoUpper(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	@JsonSetter("email")
	public void setEmail(String email) {
		this.email = email;
	}
	
	@JsonSetter("Email")
	public void setEmailUpper(String email) {
		this.email = email;
	}

	public String getChangeBy() {
		return changeBy;
	}

	@JsonSetter("changeBy")
	public void setChangeBy(String changeBy) {
		this.changeBy = changeBy;
	}
	
	@JsonSetter("ChangeBy")
	public void setChangeByUpper(String changeBy) {
		this.changeBy = changeBy;
	}

	

}
