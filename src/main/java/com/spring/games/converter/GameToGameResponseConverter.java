package com.spring.games.converter;

import org.springframework.core.convert.converter.Converter;

import com.spring.games.dto.response.GameResponse;
import com.spring.games.entitys.Game;

public class GameToGameResponseConverter implements Converter<Game, GameResponse>{

	@Override
	public GameResponse convert(Game game) {
		GameResponse gameResponse = new GameResponse();
		gameResponse.setName(game.getName());
		gameResponse.setId(game.getId());
		gameResponse.setPrice(game.getPrice());
		gameResponse.setRating(game.getRating());
		return gameResponse;
	}

}
