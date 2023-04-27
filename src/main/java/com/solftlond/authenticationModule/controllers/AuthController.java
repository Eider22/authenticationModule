package com.solftlond.authenticationModule.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller; //iniatial dependencies
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping; //webflux dependency
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping; //webflux dependency

import com.solftlond.authenticationModule.pojo.LoginRequest;
import com.solftlond.authenticationModule.responses.Response;
import com.solftlond.authenticationModule.services.implementations.AuthService;

import reactor.core.publisher.Mono; //webflux dependency

@Controller
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private AuthService authService;

	@CrossOrigin(origins = "*")
	@PostMapping("/login")
	public Mono<ResponseEntity<Response>> login(@RequestBody  LoginRequest login) {

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json; charset-UTF-8");

		Mono<Response> loggeo = this.authService.login(login);

		if (loggeo == null) {
			ResponseEntity<Response> response = new ResponseEntity<Response>(null, headers, HttpStatus.UNAUTHORIZED);
			return Mono.just(response);
		}

		return loggeo.map(logg -> {

			
			ResponseEntity<Response> response = new ResponseEntity<Response>(logg, headers, HttpStatus.OK);

			return response;
		});
	}

}
