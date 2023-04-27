package com.solftlond.authenticationModule.services.implementations;

import org.springframework.stereotype.Service;

@Service
public class JwtService {

	private static Integer token;

	public JwtService() {
		token = 0;
	}

	public static Integer getToken() {
		token = token + 1;
		return token;
	}

	public static void setToken(Integer token) {
		JwtService.token = token;
	}

}
