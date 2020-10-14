package com.spring.games.exceptions.generic;

public class IsAlreadySetExeption extends RuntimeException{

	private static final long serialVersionUID = 1L;
	private final String detalles;
	
	public IsAlreadySetExeption(String detalles) {
		this.detalles = detalles;
	}

	public String getDetalles() {
		return detalles;
	}
	
}
