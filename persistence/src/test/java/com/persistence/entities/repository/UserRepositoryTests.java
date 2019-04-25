package com.persistence.entities.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringRunner;

import com.persistence.entities.impl.ContactEntity;
import com.persistence.entities.impl.UserEntity;
import com.persistence.entities.repository.dataset.ContactDataset;
import com.persistence.entities.repository.dataset.UserDataset;
import com.persistence.entities.respository.UserRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTests {
	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private UserRepository users;
	
	@Test
	public void testFindByApellido() {
		final UserEntity newUser = UserDataset.newUsers()[0];
		entityManager.merge(newUser);
		List<UserEntity> findByLastName = users.findByApellido(newUser.getApellido());
		assertThat(findByLastName).extracting(UserEntity::getApellido).containsOnly(newUser.getApellido());
	}
	
	@Test
	public void testCountStoreData() {
		UserEntity newUser0 = UserDataset.newUsers()[3];
		UserEntity newUser1 = UserDataset.newUsers()[2];
		UserEntity newUser2 = UserDataset.newUsers()[1];
		
		//insert three users
		entityManager.persist(newUser0);
		entityManager.persist(newUser1);
		entityManager.persist(newUser2);
		
		List<UserEntity> userList = (List<UserEntity>) users.findAll();
		assertThat(userList).hasSize(3);
	}

	@Test
	public void testFindByEmail() {
		UserEntity newUser0 = UserDataset.newUsers()[3];
		UserEntity newUser1 = UserDataset.newUsers()[2];
		UserEntity newUser2 = UserDataset.newUsers()[1];
		
		//insert three users
		entityManager.persist(newUser0);
		entityManager.persist(newUser1);
		entityManager.persist(newUser2);
		
		final String email = ContactDataset.newContacts()[3].getEmail();
		List<UserEntity> userList = users.findByEmail(email);
		assertThat(userList.get(0).getContact()).extracting(ContactEntity::getEmail).containsOnly(email);
	}

	@Test(expected = DataIntegrityViolationException.class)
	public void testDuplicatedUserData() {
		UserEntity newUser0 = UserDataset.newUsers()[1];
		UserEntity newUser1 = UserDataset.newUsers()[1];
		
		
		//insert two users with the same data user
		entityManager.persist(newUser0);
		entityManager.persist(newUser1);
		
		List<UserEntity> findByEmail = users.findByApellido(newUser0.getApellido());
	}



}