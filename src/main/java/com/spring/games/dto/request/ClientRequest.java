package com.spring.games.dto.request;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class ClientRequest {
	
	@NotBlank(message = "DNI del cliente obligatorio")
	private String dni;
	
	@NotBlank(message = "Nombre del cliente obligatorio")
	private String name;
	
	@NotBlank(message = "Apellidos del cliente obligatorios")
	private String lastName;
	
}
