package com.persistence.entities.impl;

import static java.util.Objects.requireNonNull;
import static javax.persistence.FetchType.LAZY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.base.persistence.BaseEntity;

@Entity
@Table(name = "contact")
public class ContactEntity extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Column(nullable = false, unique = true)
	private String telefono;

	@Column(nullable = false, unique = true)
	private String email;

	@JoinColumn(name = "CONTACT_ID")
	@OneToOne(fetch = LAZY)
	private UserEntity user;

	@SuppressWarnings("unused")
	private ContactEntity() {
	}

	/**
	 * This constructor is for new contact creation
	 * 
	 * @param createdNameBy
	 * @param modifiedNameBy
	 * @param modificationDate
	 * @param id
	 * @param telefono
	 * @param email
	 */
	public ContactEntity(final String createdNameBy, final String modifiedNameBy, final String telefono, final String email) {
		super(createdNameBy, modifiedNameBy);
		requireNonNull(telefono);
		this.telefono = telefono;
		requireNonNull(email);
		this.email = email;
	}

	/**
	 * This constructor is for modification
	 * 
	 * @param modifiedNameBy
	 * @param telefono
	 * @param email
	 */
	public ContactEntity(final String modifiedNameBy, final String telefono, final String email) {
		super(modifiedNameBy);
		requireNonNull(telefono);
		this.telefono = telefono;
		requireNonNull(email);
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "ContactEntity [id=" + this.getId() + ", telefono=" + telefono + ", email=" + email + "]";
	}

}
