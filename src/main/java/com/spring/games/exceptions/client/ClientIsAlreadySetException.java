package com.spring.games.exceptions.client;

import com.spring.games.exceptions.generic.IsAlreadySetExeption;

public class ClientIsAlreadySetException extends IsAlreadySetExeption{

	private static final long serialVersionUID = 1L;
	private static final String DETALLES = "El cliente ya se encuentra agregado";
	
	public ClientIsAlreadySetException(String detalles) {
		super(detalles);
	}
	
	public ClientIsAlreadySetException() {
		super(DETALLES);
	}

}
