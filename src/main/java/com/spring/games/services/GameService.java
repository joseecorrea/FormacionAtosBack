package com.spring.games.services;

import java.util.List;
import java.util.Optional;

import com.spring.games.dto.request.GameRequest;
import com.spring.games.dto.response.GenericShortResponse;
import com.spring.games.entitys.Game;
import com.spring.games.dto.response.GenderResponse;

public interface GameService {

	public Object getGame(String title);
	
	public void addGame(GameRequest game);
	
	public List<GenderResponse> getGendersGame(String name);
	
	public GenericShortResponse updateGame(Long id, GameRequest gameRequest);
	
	public GenericShortResponse deleteGame(String name);
	
	public Optional<Game> getGame(Long id);
}
