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
import com.spring.games.dto.request.StockRequest;
import com.spring.games.services.StockService;

@RestController
public class StockController {

	@Autowired
	StockService stockService;
	
	@PostMapping("/stocks")
	public Object createStock(@Valid @RequestBody StockRequest stockRequest){
		return ResponseEntity.status(HttpStatus.OK).body(stockService.createStock(stockRequest));		
	}
	
	@GetMapping("/stocks")
	public Object getStock(@RequestParam("gameID") Long gameID, @RequestParam("shopID") Long shopID){
		return ResponseEntity.status(HttpStatus.OK).body(stockService.getStock(gameID, shopID));		
	}
	
	@GetMapping("/addStock")
	public Object addStock(@RequestParam("gameID") Long gameID, @RequestParam("shopID") Long shopID,@RequestParam("units") Long unitsToAdd){
		return ResponseEntity.status(HttpStatus.OK).body(stockService.addStock(gameID, shopID, unitsToAdd));		
	}
	
	@GetMapping("/removeStock")
	public Object removeStock(@RequestParam("gameID") Long gameID, @RequestParam("shopID") Long shopID){
		return ResponseEntity.status(HttpStatus.OK).body(stockService.removeStock(gameID, shopID));		
	}
	
	@GetMapping("/restartStock")
	public Object restartStock(@RequestParam("gameID") Long gameID, @RequestParam("shopID") Long shopID){
		return ResponseEntity.status(HttpStatus.OK).body(stockService.restartStock(gameID, shopID));		
	}
	
}
