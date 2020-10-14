package com.spring.games.helper;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import com.spring.games.dto.response.GameResponse;
import com.spring.games.dto.response.GenderResponse;
import com.spring.games.entitys.Game;
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
}
