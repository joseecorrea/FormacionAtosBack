package com.spring.games.converter;

import org.springframework.core.convert.converter.Converter;

import com.spring.games.dto.request.StockRequest;
import com.spring.games.entitys.Stock;

public class StockRequestToStockConverter implements Converter<StockRequest, Stock>{


	
	@Override
	public Stock convert(StockRequest stockRequest) {
		Stock stock = new Stock();
		stock.setUnits(stockRequest.getUnits());
		return stock;
	}
}
