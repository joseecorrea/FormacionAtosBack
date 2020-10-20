package com.spring.games.dto.response;

import lombok.Data;

@Data
public class GenericShortResponse {

	private String name;
	
	private String message;
	
	public GenericShortResponse(String name, String message) {
		this.name = name;
		this.message = message;
	}
	
	public GenericShortResponse() {
	}

}
