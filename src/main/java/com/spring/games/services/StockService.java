package com.spring.games.services;

import com.spring.games.dto.request.StockRequest;
import com.spring.games.dto.response.GenericShortResponse;
import com.spring.games.dto.response.StockResponse;


public interface StockService{
	
	public GenericShortResponse createStock(StockRequest stock);
	
	public StockResponse getStock(Long id_game,Long id_shop);
	
	public StockResponse addStock(Long id_game,Long id_shop,Long unitsToAdd);
	
	public StockResponse removeStock(Long id_game,Long id_shop);
	
	public StockResponse restartStock(Long id_game,Long id_shop);
	
}
