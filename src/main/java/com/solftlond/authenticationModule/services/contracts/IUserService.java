package com.solftlond.authenticationModule.services.contracts;

import com.solftlond.authenticationModule.models.User;

import reactor.core.publisher.Mono;

public interface IUserService {
	 Mono<User> findByEmail(String email);
}
