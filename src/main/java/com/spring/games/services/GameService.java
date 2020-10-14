package com.spring.games.services;

import java.util.List;

import com.spring.games.dto.request.GameRequest;
import com.spring.games.dto.response.GenderResponse;

public interface GameService {

	public Object getGame(String title);
	
	public void addGame(GameRequest game);
	
	public List<GenderResponse> getGendersGame(String name);
}
