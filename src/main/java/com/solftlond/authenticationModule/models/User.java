package com.solftlond.authenticationModule.models;

public class User {

	private Integer id;
	private String firstName;
	private String secondName;
	private String firstlastname;
	private String secondLastname;
	private String email;
	private String password;

	public User(Integer id, String firstName, String secondName, String firstlastname, String secondLastname,
			String email, String password) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.secondName = secondName;
		this.firstlastname = firstlastname;
		this.secondLastname = secondLastname;
		this.email = email;
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getFirstlastname() {
		return firstlastname;
	}

	public void setFirstlastname(String firstlastname) {
		this.firstlastname = firstlastname;
	}

	public String getSecondLastname() {
		return secondLastname;
	}

	public void setSecondLastname(String secondLastname) {
		this.secondLastname = secondLastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
