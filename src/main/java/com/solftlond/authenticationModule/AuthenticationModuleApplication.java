package com.solftlond.authenticationModule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AuthenticationModuleApplication {

	public static void main(String[] args) {
//		System.setProperty("server.servlet.context-path", "/api");
		SpringApplication.run(AuthenticationModuleApplication.class, args);
	}

}
