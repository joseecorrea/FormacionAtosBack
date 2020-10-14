package com.spring.games.converter;

import org.springframework.core.convert.converter.Converter;

import com.spring.games.dto.response.GameResponseShort;
import com.spring.games.entitys.Game;

public class GameToGameResponseShortConverter implements Converter<Game, GameResponseShort>{

	@Override
	public GameResponseShort convert(Game game) {
		GameResponseShort gameResponse = new GameResponseShort();
		gameResponse.setName(game.getName());
		return gameResponse;
	}

}
