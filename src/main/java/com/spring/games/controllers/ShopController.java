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
import com.spring.games.dto.request.ShopRequest;
import com.spring.games.dto.response.GenericShortResponse;
import com.spring.games.services.ShopService;

@RestController
public class ShopController {

	@Autowired
	ShopService shopService;
	
	@PostMapping("/shops")
	public Object addGame(@Valid @RequestBody ShopRequest shopRequest){
		shopService.addShop(shopRequest);
		return ResponseEntity.status(HttpStatus.OK).body(new GenericShortResponse(shopRequest.getName(),"Añadido correctamente"));		
	}
	
	@GetMapping("/shops")
	public Object getGame(@RequestParam("name") String name){	
		return ResponseEntity.status(HttpStatus.OK).body(shopService.getShop(name));		
	}
}
