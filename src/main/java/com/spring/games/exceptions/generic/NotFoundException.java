package com.spring.games.exceptions.generic;

public class NotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	private final String detalle;
	
	public NotFoundException(String detalle) {
		this.detalle = detalle;
	}

	public String getDetalle() {
		return detalle;
	}
		
}
