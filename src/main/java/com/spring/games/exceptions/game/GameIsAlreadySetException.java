package com.spring.games.exceptions.game;

import com.spring.games.exceptions.generic.IsAlreadySetExeption;

public class GameIsAlreadySetException extends IsAlreadySetExeption{

	private static final long serialVersionUID = 1L;
	private static final String DETALLES = "El juego ya se encuentra agregado";

	public GameIsAlreadySetException(String detalles) {
		super(detalles);
	}

	public GameIsAlreadySetException() {
		super(DETALLES);
	}

	
}
