package com.persistence.entities.impl;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.base.persistence.BaseEntity;
import com.base.persistence.IEntity;

/**
 * @author RMehdi
 *
 */
@Entity
@Table(name = "user")
public class UserEntity extends BaseEntity implements IEntity<Long,String, Date, String> {

	private static final long serialVersionUID = 1L;

	@Column(nullable = false)
	private String nombre;
	
	@Column(nullable = false)
	private String apellido;

	@Column(nullable = false)
	private long edad;
	
	@Column(name="INSCRIPTION_DATE",nullable = false)
	private Date inscriptionDate;

	@OneToOne(fetch = FetchType.EAGER, cascade= CascadeType.ALL)
	private ContactEntity contact;
	
	@SuppressWarnings("unused")
	private UserEntity() {
	}
	
	/**
	 * New record 
	 * 
	 * @param createdNameBy
	 * @param modifiedNameBy
	 * @param contact
	 * @param nombre
	 * @param apellido
	 * @param edad
	 * @param inscriptionDate
	 */
	public UserEntity(
			final String createdNameBy, 
			final String modifiedNameBy, 
			final ContactEntity contact, 
			final String nombre, 
			final String apellido,
			final Long edad, 
			final Date inscriptionDate
			) {
		super(createdNameBy, modifiedNameBy);
		this.contact = contact;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.inscriptionDate = inscriptionDate;
	}
	
	public UserEntity(
			final String modifiedNameBy, 
			final ContactEntity contact, 
			final String nombre, 
			final String apellido, 
			final Long edad,
			Date inscriptionDate
			) {
		super(modifiedNameBy);
		this.contact = contact;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.inscriptionDate = inscriptionDate;
	}

	public ContactEntity getContact() {
		return contact;
	}

	public void setContact(ContactEntity contact) {
		this.contact = contact;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public Long getEdad() {
		return edad;
	}
	
	public Date getInscriptionDate() {
		return inscriptionDate;
	}

	@Override
	public String toString() {
		return String.format("UserEntity [id=%s, nombre=%s, apellido=%s, edad=%s, inscriptionDate=%s, contact=%s]", super.getId(),
				nombre, apellido, edad, inscriptionDate, contact);
	}

}
