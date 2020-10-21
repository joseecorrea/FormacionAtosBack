package com.spring.games.exceptions.shop;

import com.spring.games.exceptions.generic.NotFoundException;

public class ShopNotFoundException extends NotFoundException{

	private static final long serialVersionUID = 1L;
	private static final String DETALLES = "Tienda no encontrada";
	
	public ShopNotFoundException(String detalle) {
		super(detalle);
	}
	
	public ShopNotFoundException() {
		super(DETALLES);
	}

}
