package com.solftlond.authenticationModule.pojo;

public class LoginResponse {

	private Integer token;
	private String user;

	public LoginResponse(Integer token, String user) {
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

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

}
