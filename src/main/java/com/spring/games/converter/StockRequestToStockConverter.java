package com.spring.games.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import com.spring.games.dto.request.StockRequest;
import com.spring.games.entitys.Stock;
import com.spring.games.repositorys.GameRepository;
import com.spring.games.repositorys.ShopRepository;
import com.spring.games.services.GameService;

public class StockRequestToStockConverter implements Converter<StockRequest, Stock>{


	
	@Override
	public Stock convert(StockRequest stockRequest) {
		return null;
	}
}
