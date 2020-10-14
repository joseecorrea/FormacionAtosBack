package com.spring.games.helper;

import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.games.converter.GameToGameResponseConverter;
import com.spring.games.converter.GenderToGenderResponseConverter;
import com.spring.games.dto.request.GameRequest;
import com.spring.games.dto.response.GameResponse;
import com.spring.games.entitys.Game;
import com.spring.games.exceptions.GameNotFoundException;

@Service
public class GameHelper {

	
	GameToGameResponseConverter gTGRC = new GameToGameResponseConverter();
	
	
	GenderToGenderResponseConverter gTGeRC = new GenderToGenderResponseConverter();
	
	public GameResponse isInDBAndConv(Optional<Game> game) {
		if(game.isPresent()) {	
			GameResponse gameResponse = gTGRC.convert(game.get());
			gameResponse.setGameGenders(game.get().getGameGenders().stream().map(m -> gTGeRC.convert(m)).collect(Collectors.toList()));
			return gameResponse;
		}else {
			throw new GameNotFoundException();
		}
	}
}
