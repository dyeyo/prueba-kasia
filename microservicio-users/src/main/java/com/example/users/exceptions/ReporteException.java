package com.example.users.exceptions;


import org.springframework.http.HttpStatus;

public class ReporteException  extends ParentException {

	ReporteException(String string) {
		 super(HttpStatus.UNPROCESSABLE_ENTITY);
    }

	
	
}
