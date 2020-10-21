package com.spring.games.exceptions.stock;

import com.spring.games.exceptions.generic.NotFoundException;

public class StockNotFoundException extends NotFoundException{

	private static final long serialVersionUID = 1L;
	private static final String DETALLES = "Stock no encontrado";
	
	public StockNotFoundException(String detalle) {
		super(detalle);
	}
	
	public StockNotFoundException() {
		super(DETALLES);
	}

}
