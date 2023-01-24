package com.example.users.exceptions;

import org.springframework.http.HttpStatus;

public class ParentException  extends RuntimeException {

	private HttpStatus status;
	
	ParentException(HttpStatus status, String s){
		super(s);
		this.status = status;
	}
	
	ParentException(HttpStatus status){
		super();
		this.status = status;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}
}
