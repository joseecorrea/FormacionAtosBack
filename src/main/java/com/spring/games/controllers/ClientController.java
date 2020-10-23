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

import com.spring.games.dto.request.ClientRequest;
import com.spring.games.services.ClientService;

@RestController
public class ClientController {

	@Autowired
	ClientService clientService;
	
	@PostMapping("/clients")
	public Object createClient(@Valid @RequestBody ClientRequest clientRequest){
		return ResponseEntity.status(HttpStatus.OK).body(clientService.addClient(clientRequest));		
	}
	
	@GetMapping("/clients")
	public Object getClient(@RequestParam("dni") String dni){
		return ResponseEntity.status(HttpStatus.OK).body(clientService.getClient(dni));		
	}
	
}
