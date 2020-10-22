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
import com.spring.games.exceptions.game.GameNotFoundException;
import com.spring.games.exceptions.shop.ShopNotFoundException;
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
		
		Optional<Stock> stockO = getStockIfShopAndGameExist(stockRequest.getGameID(), stockRequest.getShopID());
		if(stockO.isEmpty()) {
			Stock stock = cs.convert(stockRequest, Stock.class);
			stock = addShopAndGameToStock(stockRequest.getGameID(), stockRequest.getShopID(), stock);
			stockRepository.save(stock);				
			return 	new GenericShortResponse("ok","ha sido añadido con exito");		
		}else {
			throw new StockIsAlreadySetException();
		}
		
	}

	@Override
	public StockResponse getStock(Long id_game, Long id_shop) {
		
		Optional<Stock> stockO = getStockIfShopAndGameExist(id_game, id_shop);
		if (stockO.isPresent()) {
			return 	cs.convert(stockO.get(), StockResponse.class);		
		}else {
			throw new StockNotFoundException();
		}

	}

	@Override
	public StockResponse addStock(Long id_game, Long id_shop,Long unitsToAdd) {
				
		Optional<Stock> stockO = getStockIfShopAndGameExist(id_game, id_shop);
		if (stockO.isPresent()) {
			Long units =  stockO.get().getUnits();
			units = units + unitsToAdd;
			stockO.get().setUnits(units);
			stockRepository.save(stockO.get());				
			return 	cs.convert(stockO.get(), StockResponse.class);		
		}else {
			throw new StockNotFoundException();
		}	
				
	}

	@Override
	public StockResponse removeStock(Long id_game, Long id_shop) {
			
		Optional<Stock> stockO = getStockIfShopAndGameExist(id_game, id_shop);
		if (stockO.isPresent()) {
			Long units =  stockO.get().getUnits();
			units = units - 1;
			stockO.get().setUnits(units);
			stockRepository.save(stockO.get());				
			return 	cs.convert(stockO.get(), StockResponse.class);		
		}else {
			throw new StockNotFoundException();
		}	

	}

	@Override
	public StockResponse restartStock(Long id_game, Long id_shop) {
			
		Optional<Stock> stockO = getStockIfShopAndGameExist(id_game, id_shop);
		if (stockO.isPresent()) {
			Long units =  stockO.get().getUnits();
			units = 0L;
			stockO.get().setUnits(units);
			stockRepository.save(stockO.get());				
			return 	cs.convert(stockO.get(), StockResponse.class);		
		}else {
			throw new StockNotFoundException();
		}

	}
	
	
	public Optional<Stock> getStockIfShopAndGameExist(Long gameID, Long shopID) {
		
		Optional<Game> gameO = gameService.getGame(gameID);
		Optional<Shop> shopO = shopService.getShop(shopID);		;
		if(gameO.isPresent() && shopO.isPresent()) {
			return  stockRepository.findByShopAndGame(shopO.get(),gameO.get());
		}else {
			if(gameO.isEmpty()) {
				throw new GameNotFoundException();
			}else {
				throw new ShopNotFoundException();
			}
		}
	}
	
	public Stock addShopAndGameToStock(Long gameID,Long shopID,Stock stock) {
		Optional<Game> gameO = gameService.getGame(gameID);
		Optional<Shop> shopO = shopService.getShop(shopID);	
		if(gameO.isPresent() && shopO.isPresent()) {
			stock.setGame(gameO.get());
			stock.setShop(shopO.get());
			return stock;
		}else {
			if(gameO.isEmpty()) {
				throw new GameNotFoundException();
			}else {
				throw new ShopNotFoundException();
			}
		}
	}
		

}
