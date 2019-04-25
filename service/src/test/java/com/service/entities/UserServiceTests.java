package com.service.entities;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;

import com.service.entities.dto.UserDto;

@RunWith(SpringRunner.class)
@ComponentScan({ "com.*" })
@EnableJpaRepositories("com.*")
public class UserServiceTests {

	@Autowired
	private UserService userService;

	@Test
	public void testFindByLastName() {
		final UserDto t = UserDtoDataset.newUsers()[0];
		boolean user = userService.addOrUpdate(t);
		assertThat(user).isTrue();
		List<UserDto> retrievedUser = userService.findByEmail("email1@smtp.fr");

		assertThat(retrievedUser).extracting(UserDto::getNombre).containsOnly(t.getNombre());
	}

	@Test
	public void testCreationNewUser() {
		final UserDto newUser = UserDtoDataset.newUsers()[0];
		boolean storedUser = userService.addOrUpdate(newUser);
		assertThat(storedUser).isTrue();
	}

	@Test
	public void testFindByEmail() {
		final UserDto newUser = UserDtoDataset.newUsers()[0];
		final boolean user = userService.addOrUpdate(newUser);
		assertThat(user).isTrue();
		List<UserDto> findByEmail = userService.findByEmail(newUser.getEmail());
		assertThat(findByEmail).extracting(UserDto::getEmail).containsOnly(newUser.getEmail());
	}

	@Test
	public void testCountStoreData() {
		UserDto newUser0 = UserDtoDataset.newUsers()[3];
		UserDto newUser1 = UserDtoDataset.newUsers()[2];
		UserDto newUser2 = UserDtoDataset.newUsers()[1];

		// insert three users
		boolean user = userService.addOrUpdate(newUser0);
		assertThat(user).isTrue();
		user = userService.addOrUpdate(newUser1);
		assertThat(user).isTrue();
		user = userService.addOrUpdate(newUser2);
		assertThat(user).isTrue();

		List<UserDto> userList = userService.getAll();
		assertThat(userList).hasSize(3);
	}

	@Test(expected = DataIntegrityViolationException.class)
	public void testDuplicatedUserData() {
		UserDto newUser0 = UserDtoDataset.newUsers()[1];
		UserDto newUser1 = UserDtoDataset.newUsers()[1];

		// insert two users with the same data user
		boolean user = userService.addOrUpdate(newUser0);
		assertThat(user).isTrue();
		user = userService.addOrUpdate(newUser1);
		assertThat(user).isTrue();

		List<UserDto> findByEmail = userService.findByEmail(newUser0.getEmail());
		assertThat(findByEmail).extracting(UserDto::getEmail).containsOnly(newUser1.getEmail());
	}

	@Test//(expected = MethodArgumentNotValidException.class)
	public void testStoredUserWithEmptyData() {
		UserDto newUser0 = UserDtoDataset.newUsers()[7];

		// insert user with incorrect email
		boolean user = userService.addOrUpdate(newUser0);
		assertThat(user).isTrue();

		List<UserDto> findByEmail = userService.findByEmail(newUser0.getEmail());
	}

}
