package com.solftlond.authenticationModule.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solftlond.authenticationModule.models.User;
import com.solftlond.authenticationModule.repositories.implmentations.UserRepository;
import com.solftlond.authenticationModule.services.contracts.IUserService;

import reactor.core.publisher.Mono;

@Service
public class UserService implements IUserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public Mono<User> findByEmail(String email) {

		Mono<User> findUser = this.userRepository.findbyEmail(email);

		if (findUser == null) {
			System.out.println("Es null");
			return null;
		}

		return findUser.map(usuario -> {
			if (usuario == null) {
				return null;
			}

			return usuario;
		});

	}

}
