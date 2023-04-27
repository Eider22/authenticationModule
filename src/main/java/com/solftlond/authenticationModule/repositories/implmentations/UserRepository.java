package com.solftlond.authenticationModule.repositories.implmentations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.solftlond.authenticationModule.models.User;
import com.solftlond.authenticationModule.repositories.contracts.IUserRepository;

import reactor.core.publisher.Mono;

@Repository
public class UserRepository implements IUserRepository {

	private List<User> harcodedUsers = new ArrayList<User>();

	public UserRepository() {
		this.fillHarcodedUsers();
	}

	@Override
	public Mono<User> findbyEmail(String email) {

		User findUser = this.harcodedUsers.stream().filter(user -> user.getEmail().equals(email)).findFirst().map(u -> {
			return new User(u.getId(), u.getFirstName(), u.getSecondName(), u.getFirstlastname(), u.getSecondLastname(),
					u.getEmail(), u.getPassword());
		}).orElse(null);

		if (findUser == null) {
			return null;
		}
		
		return Mono.just(findUser);
	}

	public void fillHarcodedUsers() {
		this.harcodedUsers
				.add(new User(1, "John", "Eider", "Cardona", "Catrillón", "john.1701627015@ucaldas.edu.co", "1234"));
		this.harcodedUsers.add(new User(1, "Juan", "Pedro", "Lopez", "Torres", "juan@gmail.com", "0000"));
		this.harcodedUsers.add(new User(1, "Pablo", "Andres", "Lorca", "Yepes", "pablo@gmail.com", "1111"));
	}

}
