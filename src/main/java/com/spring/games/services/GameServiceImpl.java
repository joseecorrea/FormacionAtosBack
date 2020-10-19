package com.spring.games.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import com.spring.games.dto.request.GameRequest;
import com.spring.games.dto.response.GameResponse;
import com.spring.games.dto.response.GameResponseShort;
import com.spring.games.dto.response.GenderResponse;
import com.spring.games.entitys.Game;
import com.spring.games.entitys.Gender;
import com.spring.games.enums.GenreEnum;
import com.spring.games.exceptions.GameIsAlreadySet;
import com.spring.games.helper.GameHelper;
import com.spring.games.repositorys.GameRepository;

@Service
public class GameServiceImpl implements GameService {

	@Autowired
	GameHelper gameHelper;
	
	@Autowired
	GameRepository gameRepository;
	
	@Autowired
	GenderService genderService;
	
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
				genderService.ifExistAssociate(m, gendersList, game);
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

	@Override
	public GameResponseShort updateGame(Long id, GameRequest gameRequest) {
		GameResponseShort respuesta = new GameResponseShort();
		Optional<Game> gameOptional = gameRepository.findById(id);
		if (gameOptional.isPresent()) {
			Game game = gameHelper.updateProperties(gameRequest, gameOptional.get());
			gameRepository.save(game);
			respuesta.setName(game.getName());
			respuesta.setMessage("Ha sido actualizado");
		}else {
			respuesta.setMessage("No se ha encontrado el juego a actualizar");
		}
		return respuesta;
	}

	@Override
	public GameResponseShort deleteGame(String name) {
		GameResponseShort respuesta = new GameResponseShort();
		Optional<Game> gameOptional = gameRepository.findByName(name);
		if (gameOptional.isPresent()) {
			gameRepository.delete(gameOptional.get());
			respuesta.setName(gameOptional.get().getName());
			respuesta.setMessage("Ha sido Eliminado");
		}else {
			respuesta.setMessage("No se ha encontrado el juego a eliminar");
		}
		return respuesta;
	}

}
