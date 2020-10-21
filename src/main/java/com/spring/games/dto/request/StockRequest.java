package com.spring.games.dto.request;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class StockRequest {

	@NotNull(message = "tienda obligatorio")
	private Long shopID;
	
	@NotNull(message = "juego obligatorio")
	private Long gameID;
	
	@NotNull(message = "Es necesario una cantidad de unidades")
	private Long units;
	
}
