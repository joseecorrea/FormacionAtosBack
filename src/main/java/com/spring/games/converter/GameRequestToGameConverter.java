package com.spring.games.converter;

import org.springframework.core.convert.converter.Converter;

import com.spring.games.dto.request.GameRequest;
import com.spring.games.entitys.Game;

public class GameRequestToGameConverter implements Converter<GameRequest, Game>{

	@Override
	public Game convert(GameRequest gameRequest) {
		// TODO Auto-generated method stub
		Game game = new Game();
		game.setName(gameRequest.getName());
		game.setPrice(gameRequest.getPrice());
		game.setRating(gameRequest.getRating());
		return game;
	}

}
