package com.solftlond.authenticationModule.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service; // initial dependencies

import com.solftlond.authenticationModule.models.User;
import com.solftlond.authenticationModule.pojo.LoginRequest;
import com.solftlond.authenticationModule.pojo.LoginResponse;
import com.solftlond.authenticationModule.responses.Response;
import com.solftlond.authenticationModule.services.contracts.IAuthService;

import reactor.core.publisher.Mono;

@Service
public class AuthService implements IAuthService {

	@Autowired
	private UserService userService;

	@Override
	public Mono<Response> login(LoginRequest loginRequest) {

		Mono<User> findUser = this.userService.findByEmail(loginRequest.getUser());
		
		System.out.println(findUser);

		if (findUser == null) {
			return null;
		}

		return findUser.map(user -> {
			if (user == null) {
				return new Response("Credenciales incorrectas", null);
			}

			if (!(user.getEmail().equals(loginRequest.getUser())
					&& user.getPassword().equals(loginRequest.getPassword()))) {
				return new Response("Credenciales incorrectas", null);
			}

			LoginResponse loginResponse = new LoginResponse("token", user.getEmail());

			Response response = new Response("", loginResponse);
			return response;
		});

	}

}
