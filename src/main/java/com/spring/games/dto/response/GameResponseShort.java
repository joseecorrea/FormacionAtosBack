package com.spring.games.dto.response;

import lombok.Data;

@Data
public class GameResponseShort {

	private String name;
	
	private String message;
	
	public GameResponseShort(String name, String message) {
		this.name = name;
		this.message = message;
	}
	
	public GameResponseShort() {
	}

}
