package com.persistence.entities.repository.dataset;

import java.util.Date;

import com.persistence.entities.impl.UserEntity;

public final class UserDataset {

	// Disallow construction
	private UserDataset() {
	}

	/**
	 * An array of five accounts that should exist in the database. 
	 * 
	 * @return An array of four {@link UserEntity}
	 */
	public static UserEntity[] newUsers() {
		return new UserEntity[] {
				new UserEntity("TESTSYS", "TESTSYS", ContactDataset.newContacts()[0], "nombre1", "apellido1", 45L, new Date()),
				new UserEntity("TESTSYS", "TESTSYS", ContactDataset.newContacts()[1], "nombre2", "apellido2", 28L, new Date()),
				new UserEntity("TESTSYS", "TESTSYS", ContactDataset.newContacts()[2], "nombre3", "apellido3", 16L, new Date()),
				new UserEntity("TESTSYS", "TESTSYS", ContactDataset.newContacts()[3], "nombre4", "apellido4", 90L, new Date()),
				new UserEntity("TESTSYS", "TESTSYS", ContactDataset.newContacts()[4], "nombre4", "apellido4", 90L, new Date()),/**incorrect email*/
				new UserEntity("TESTSYS", "TESTSYS", ContactDataset.newContacts()[5], "nombre4", "apellido4", 90L, new Date()) /**incorrect age null*/};
	}

}
