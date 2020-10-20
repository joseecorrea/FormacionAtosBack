package com.spring.games.dto.request;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class ShopRequest {
	
	@NotBlank(message = "Nombre de la tienda obligatorio")
	private String name;
	
	@NotBlank(message = "Direccion de la tienda obligatorio")
	private String address;
	
	@NotBlank(message = "Codigo postal de la tienda obligatorio")
	private String zc;
	
}
