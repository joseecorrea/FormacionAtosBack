package com.spring.games.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import com.spring.games.dto.request.StockRequest;
import com.spring.games.dto.response.GenericShortResponse;
import com.spring.games.dto.response.StockResponse;
import com.spring.games.entitys.Game;
import com.spring.games.entitys.Shop;
import com.spring.games.entitys.Stock;
import com.spring.games.exceptions.generic.IsAlreadySetExeption;
import com.spring.games.exceptions.stock.StockIsAlreadySetException;
import com.spring.games.exceptions.stock.StockNotFoundException;
import com.spring.games.repositorys.StockRepository;

@Service
public class StockServiceImpl implements StockService {

	@Autowired
	StockRepository stockRepository;
	
	@Autowired
	GameService gameService;
	
	@Autowired
	ShopService shopService;
	
	@Autowired
	ConversionService cs;
	
	@Override
	public GenericShortResponse createStock(StockRequest stockRequest) {
		
		Optional<Game> gameO = gameService.getGame(stockRequest.getGameID());
		Optional<Shop> shopO = shopService.getShop(stockRequest.getShopID());		
		if(gameO.isPresent() && shopO.isPresent()) {
			Optional<Stock> stockO = stockRepository.findByShopAndGame(shopO.get(),gameO.get());
			if (stockO.isEmpty()) {	
				Stock stock = new Stock();						
				stock.setGame(gameO.get());
				stock.setShop(shopO.get());
				stock.setUnits(stockRequest.getUnits());
				stockRepository.save(stock);
				return new GenericShortResponse("ok","ha sido añadido con exito");		
			}else {
				throw new  StockIsAlreadySetException(); 
			}	
		}else {
			return new GenericShortResponse("error","problemas con los datos de la tienda o juego indicados");
		}
	}

	@Override
	public StockResponse getStock(Long id_game, Long id_shop) {
		Optional<Game> gameO = gameService.getGame(id_game);
		Optional<Shop> shopO = shopService.getShop(id_shop);		;
		if(gameO.isPresent() && shopO.isPresent()) {
			Optional<Stock> stockO = stockRepository.findByShopAndGame(shopO.get(),gameO.get());
			if (stockO.isPresent()) {	
				return 	cs.convert(stockO.get(), StockResponse.class);	
			}else {
				throw new StockNotFoundException();
			}	
		}else {
			return null;
		}
	}

	@Override
	public StockResponse addStock(Long id_game, Long id_shop,Long unitsToAdd) {
		Optional<Game> gameO = gameService.getGame(id_game);
		Optional<Shop> shopO = shopService.getShop(id_shop);		;
		if(gameO.isPresent() && shopO.isPresent()) {
			Optional<Stock> stockO = stockRepository.findByShopAndGame(shopO.get(),gameO.get());
			if (stockO.isPresent()) {
				Stock stock = stockO.get();
				Long units =  stock.getUnits();
				units = units + unitsToAdd;
				stock.setUnits(units);
				stockRepository.save(stock);				
				return 	cs.convert(stock, StockResponse.class);
				
			}else {
				throw new StockNotFoundException();
			}	
		}else {
			return null;
		}
	}

	@Override
	public StockResponse removeStock(Long id_game, Long id_shop) {
		Optional<Game> gameO = gameService.getGame(id_game);
		Optional<Shop> shopO = shopService.getShop(id_shop);		;
		if(gameO.isPresent() && shopO.isPresent()) {
			Optional<Stock> stockO = stockRepository.findByShopAndGame(shopO.get(),gameO.get());
			if (stockO.isPresent()) {
				Stock stock = stockO.get();
				Long units =  stock.getUnits();
				units = units - 1;
				stock.setUnits(units);
				stockRepository.save(stock);				
				return 	cs.convert(stock, StockResponse.class);
				
			}else {
				throw new StockNotFoundException();
			}	
		}else {
			return null;
		}
	}

	@Override
	public StockResponse restartStock(Long id_game, Long id_shop) {
		Optional<Game> gameO = gameService.getGame(id_game);
		Optional<Shop> shopO = shopService.getShop(id_shop);		;
		if(gameO.isPresent() && shopO.isPresent()) {
			Optional<Stock> stockO = stockRepository.findByShopAndGame(shopO.get(),gameO.get());
			if (stockO.isPresent()) {
				Stock stock = stockO.get();
				Long units =  stock.getUnits();
				units = 0L;
				stock.setUnits(units);
				stockRepository.save(stock);				
				return 	cs.convert(stock, StockResponse.class);				
			}else {
				throw new StockNotFoundException();
			}	
		}else {
			return null;
		}
	}
	
	

}
