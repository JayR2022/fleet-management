package com.jr.fleet.main.exceptions;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND, reason = "Car does not exist")
public class CarNotFoundException extends EntityNotFoundException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7035850310474308146L;
	
	public CarNotFoundException() {
		super();
		
	}
	
	

	
}
