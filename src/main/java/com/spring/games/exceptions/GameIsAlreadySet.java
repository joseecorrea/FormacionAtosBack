package com.spring.games.exceptions;

import com.spring.games.exceptions.generic.IsAlreadySetExeption;

public class GameIsAlreadySet extends IsAlreadySetExeption{

	private static final long serialVersionUID = 1L;
	private static final String DETALLES = "El juego ya se encuentra agregado";

	public GameIsAlreadySet(String detalles) {
		super(detalles);
	}

	public GameIsAlreadySet() {
		super(DETALLES);
	}

	
}
