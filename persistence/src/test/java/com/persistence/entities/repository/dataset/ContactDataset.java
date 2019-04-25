package com.persistence.entities.repository.dataset;

import com.persistence.entities.impl.ContactEntity;

public final class ContactDataset {

	// Disallow construction
	private ContactDataset() {
	}

	/**
	 * An array of five contacts that should exist in the database. 
	 * 
	 * @return An array of four {@link ContactEntity}
	 */
	public static ContactEntity[] newContacts() {
		return new ContactEntity[] {
				new ContactEntity("TESTSYS", "TESTSYS", "665654231435", "sads@sdss.com"),
				new ContactEntity("TESTSYS", "TESTSYS", "435345345", "fsdf@sdss.com"),
				new ContactEntity("TESTSYS", "TESTSYS", "66588654231", "fgfh@sdss.com"),
				new ContactEntity("TESTSYS", "TESTSYS", "665654231", "sads@sfds.com"),
				new ContactEntity("TESTSYS", "TESTSYS", "879879854", "fgfh@sdss"),
				new ContactEntity("TESTSYS", "TESTSYS", "66565425431", "sads@sfds.com")};
	}

}
