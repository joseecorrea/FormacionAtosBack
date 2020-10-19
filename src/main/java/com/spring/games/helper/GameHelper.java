package com.spring.games.helper;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import com.spring.games.dto.request.GameRequest;
import com.spring.games.dto.response.GameResponse;
import com.spring.games.dto.response.GenderResponse;
import com.spring.games.entitys.Game;
import com.spring.games.entitys.Gender;
import com.spring.games.exceptions.GameNotFoundException;

@Service
public class GameHelper {

	@Autowired
	ConversionService cs;
		
	public GameResponse isInDBAndConv(Optional<Game> game) {
		if(game.isPresent()) {	
			GameResponse gameResponse = cs.convert(game.get(), GameResponse.class);
			gameResponse.setGameGenders(game.get().getGameGenders().stream().map(m -> cs.convert(m, GenderResponse.class)).collect(Collectors.toList()));
			return gameResponse;
		}else {
			throw new GameNotFoundException();
		}
	}
	
	public Game updateProperties(GameRequest gameRequest,Game game) {
		game.setName(gameRequest.getName());
		game.setPrice(gameRequest.getPrice());
		game.setRating(gameRequest.getRating());
		game.setGameGenders(gameRequest.getGameGenders().stream().map(e -> cs.convert(e, Gender.class)).collect(Collectors.toList()));
		return game;
	}
}
