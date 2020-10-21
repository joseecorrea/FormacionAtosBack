package com.spring.games.exceptions.stock;

import com.spring.games.exceptions.generic.IsAlreadySetExeption;

public class StockIsAlreadySetException extends IsAlreadySetExeption{

	private static final long serialVersionUID = 1L;
	private static final String DETALLES = "El stock ya se encuentra agregado";
	
	public StockIsAlreadySetException(String detalles) {
		super(detalles);
	}
	
	public StockIsAlreadySetException() {
		super(DETALLES);
	}

}
