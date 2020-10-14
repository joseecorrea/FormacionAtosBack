package com.spring.games.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import com.spring.games.dto.request.GameRequest;
import com.spring.games.dto.response.GameResponse;
import com.spring.games.dto.response.GenderResponse;
import com.spring.games.entitys.Game;
import com.spring.games.entitys.Gender;
import com.spring.games.enums.GenreEnum;
import com.spring.games.exceptions.GameIsAlreadySet;
import com.spring.games.helper.GameHelper;
import com.spring.games.repositorys.GameRepository;
import com.spring.games.repositorys.GenderRepository;

@Service
public class GameServiceImpl implements GameService {

	@Autowired
	GameHelper gameHelper;
	
	@Autowired
	GameRepository gameRepository;
	
	@Autowired
	GenderRepository genderRepository;
	
	@Autowired
	ConversionService cs;
		
	@Override
	public GameResponse getGame(String title) {		
		return gameHelper.isInDBAndConv(gameRepository.findByName(title));
	}

	@Override
	public void addGame(GameRequest gameRequest) {	
		Optional<Game> gameOptional = gameRepository.findByName(gameRequest.getName());		
		if(gameOptional.isEmpty()) {			
			Game game =	 cs.convert(gameRequest, Game.class);		
			List<GenreEnum> gendersEnumList = gameRequest.getGameGenders();		
			List<Gender> gendersList = new ArrayList<Gender>();	
			gendersEnumList.forEach(m -> {
				Optional<Gender> genderO = genderRepository.findByName(m.name());
				if(genderO.isPresent()) {
					Gender gender = genderO.get();
					gender.getGames().add(game);
					gendersList.add(gender);
				}
			});
			game.setGameGenders(gendersList);
			gameRepository.save(game);	
		}else {
			throw new GameIsAlreadySet();
		}	
	}

	@Override
	public List<GenderResponse> getGendersGame(String name) {
		GameResponse game = getGame(name);	
		return game.getGameGenders();		
	}

}
