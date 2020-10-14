package com.spring.games.dto;

import lombok.Data;

@Data
public class GamesErrorDto {

	private String code; 
	private String message;
	
	public GamesErrorDto(String code, String message) {
		this.code = code;
		this.message = message;
	}
	
	public GamesErrorDto() {

	}
	
}
