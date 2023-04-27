package com.solftlond.authenticationModule.services.contracts;

import com.solftlond.authenticationModule.pojo.LoginRequest;
import com.solftlond.authenticationModule.responses.Response;

import reactor.core.publisher.Mono;

public interface IAuthService {

	Mono<Response> login(LoginRequest loginRequest);

}
