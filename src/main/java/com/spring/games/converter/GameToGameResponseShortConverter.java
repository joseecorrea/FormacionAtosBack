package com.spring.games.converter;

import org.springframework.core.convert.converter.Converter;

import com.spring.games.dto.response.GenericShortResponse;
import com.spring.games.entitys.Game;

public class GameToGameResponseShortConverter implements Converter<Game, GenericShortResponse>{

	@Override
	public GenericShortResponse convert(Game game) {
		GenericShortResponse gameResponse = new GenericShortResponse();
		gameResponse.setName(game.getName());
		return gameResponse;
	}

}
