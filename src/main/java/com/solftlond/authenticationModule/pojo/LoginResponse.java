package com.solftlond.authenticationModule.pojo;

import com.solftlond.authenticationModule.models.User;

public class LoginResponse {

	private Integer token;
	private User user;

	public LoginResponse(Integer token, User user) {
		super();
		this.token = token;
		this.user = user;
	}

	public Integer getToken() {
		return token;
	}

	public void setToken(Integer token) {
		this.token = token;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
