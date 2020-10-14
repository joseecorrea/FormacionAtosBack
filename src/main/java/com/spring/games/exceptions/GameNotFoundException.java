package com.spring.games.exceptions;

import com.spring.games.exceptions.generic.NotFoundException;

public class GameNotFoundException extends NotFoundException{

	
	private static final long serialVersionUID = 1L;
	private static final String DETALLES = "Juego no encontrado";

	public GameNotFoundException(String detalle) {
		super(detalle);
	}

	public GameNotFoundException() {
		super(DETALLES);
	}
	
}
