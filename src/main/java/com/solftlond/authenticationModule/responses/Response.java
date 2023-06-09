package com.solftlond.authenticationModule.responses;

public class Response {

	private String message;
	private Object object;
	
	public Response() {}


	public Response(String message, Object object) {
		super();
		this.message = message;
		this.object = object;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

}
