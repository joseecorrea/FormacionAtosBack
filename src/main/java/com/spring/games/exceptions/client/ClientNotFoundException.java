package com.spring.games.exceptions.client;

import com.spring.games.exceptions.generic.NotFoundException;

public class ClientNotFoundException extends NotFoundException{

	private static final long serialVersionUID = 1L;
	private static final String DETALLES = "Cliente no encontrado";
	
	public ClientNotFoundException(String detalle) {
		super(detalle);
	}
	
	public ClientNotFoundException() {
		super(DETALLES);
	}

}
