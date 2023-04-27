package com.solftlond.authenticationModule.services.implementation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.solftlond.authenticationModule.models.User;
import com.solftlond.authenticationModule.pojo.LoginRequest;
import com.solftlond.authenticationModule.pojo.LoginResponse;
import com.solftlond.authenticationModule.responses.Response;
import com.solftlond.authenticationModule.services.implementations.AuthService;
import com.solftlond.authenticationModule.services.implementations.JwtService;
import com.solftlond.authenticationModule.services.implementations.UserService;

import reactor.core.publisher.Mono;

public class AuthServiceTest {

	@Mock
	private UserService userService;

	@Mock
	private JwtService jwtService;

	@InjectMocks
	private AuthService authService;

	private Integer token;
	User userReturnedByuserService;
	User userExpect;
	private Response responseExpected;
	private LoginResponse loginresponseExpected;
	private LoginRequest loginRequest;
	private Mono<User> monoUser;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
		
		this.setUpLoginSuccessful();
	}

	private void setUpLoginSuccessful () {
		token = 1;

		userReturnedByuserService  = new User();
		userReturnedByuserService.setFirstName("John");
		userReturnedByuserService.setSecondName("Eider");
		userReturnedByuserService.setFirstlastname("Cardona");
		userReturnedByuserService.setSecondLastname("Catrillón");
		userReturnedByuserService.setEmail("john.1701627015@ucaldas.edu.co");
		userReturnedByuserService.setPassword("1234");
		monoUser = Mono.just(userReturnedByuserService);

		loginRequest = new LoginRequest();
		loginRequest.setUser("john.1701627015@ucaldas.edu.co");
		loginRequest.setPassword("1234");
		
		userExpect = new User();
		userExpect.setFirstName("John");
		userExpect.setSecondName("Eider");
		userExpect.setFirstlastname("Cardona");
		userExpect.setSecondLastname("Catrillón");
		userExpect.setEmail("john.1701627015@ucaldas.edu.co");
		userExpect.setPassword("");

		loginresponseExpected = new LoginResponse();
		loginresponseExpected.setToken(token);
		loginresponseExpected.setUser(userExpect);

		responseExpected = new Response();
		responseExpected.setMessage("Sesión iniciada con éxito");
		responseExpected.setObject(loginresponseExpected);

		
	}

	@Test
	public void loginSuccessful() {
		when(userService.findByEmail(userReturnedByuserService.getEmail())).thenReturn(monoUser);
		when(jwtService.getToken()).thenReturn(token);
		
		Mono<Response> response = this.authService.login(loginRequest);
		Response responseBlock = (Response) response.block();
		assertEquals("Sesión iniciada con éxito", responseBlock.getMessage());	
		
		LoginResponse loginResponse = (LoginResponse)responseBlock.getObject();
		assertEquals(loginresponseExpected.getToken(), loginResponse.getToken());
		
		
		User user = loginResponse.getUser();
		assertNotNull(user);
		assertEquals(userExpect.getFirstName(), user.getFirstName());
		assertEquals(userExpect.getSecondName(), user.getSecondName());
		assertEquals(userExpect.getFirstlastname(), user.getFirstlastname());
		assertEquals(userExpect.getSecondLastname(), user.getSecondLastname());
		assertEquals(userExpect.getEmail(), user.getEmail());
		assertEquals(userExpect.getPassword(), user.getPassword());
		
		
	}
}
