package com.solftlond.authenticationModule.repositories.contracts;

import com.solftlond.authenticationModule.models.User;

import reactor.core.publisher.Mono;

public interface IUserRepository {
	Mono<User> findbyEmail(String email);
}
