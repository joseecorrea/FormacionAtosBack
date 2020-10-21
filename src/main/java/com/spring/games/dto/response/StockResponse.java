package com.spring.games.dto.response;

import lombok.Data;

@Data
public class StockResponse {
	private Long id;
	
	private String shop;
	
	private String game;
	
	private Long units;
}
