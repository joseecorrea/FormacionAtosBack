package com.spring.games.exceptions.shop;

import com.spring.games.exceptions.generic.IsAlreadySetExeption;

public class ShopIsAlreadySetException extends IsAlreadySetExeption{

	private static final long serialVersionUID = 1L;
	private static final String DETALLES = "La tienda ya se encuentra agregada";
	
	public ShopIsAlreadySetException(String detalles) {
		super(detalles);
	}
	
	public ShopIsAlreadySetException() {
		super(DETALLES);
	}

}
