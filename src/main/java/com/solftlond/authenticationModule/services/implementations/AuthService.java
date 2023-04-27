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
	@Autowired
	private JwtService jwtService;
	

	@Override
	public Mono<Response> login(LoginRequest loginRequest) {

		Mono<User> findUser = this.userService.findByEmail(loginRequest.getUser());

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

			LoginResponse loginResponse = new LoginResponse(this.jwtService.getToken(), user.getEmail());

			Response response = new Response("", loginResponse);
			return response;
		});

	}

}
