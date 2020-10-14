package com.spring.games.controllers;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.games.dto.request.GameRequest;
import com.spring.games.dto.response.GameResponseShort;
import com.spring.games.services.GameService;


@RestController
public class GamesController{

	@Autowired
	private GameService gameService;
	
	@GetMapping("/games")
	public Object getGameId(@RequestParam("name")String name){
		return ResponseEntity.status(HttpStatus.OK).body(gameService.getGame(name));
	}
	
	@PostMapping("/games")
	public Object addGame(@Valid @RequestBody GameRequest game){
		gameService.addGame(game);
		return ResponseEntity.status(HttpStatus.OK).body(new GameResponseShort(game.getName(),"Añadido correctamente"));		
	}
	
	@GetMapping("/genders")
	public Object getGendersGame(@RequestParam("name")String name){
		return 	ResponseEntity.status(HttpStatus.OK).body(gameService.getGendersGame(name));
	}
		
}
