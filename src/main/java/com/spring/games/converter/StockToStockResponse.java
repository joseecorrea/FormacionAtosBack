package com.spring.games.converter;

import org.springframework.core.convert.converter.Converter;

import com.spring.games.dto.response.StockResponse;
import com.spring.games.entitys.Stock;

public class StockToStockResponse implements Converter<Stock, StockResponse>{

	@Override
	public StockResponse convert(Stock stock) {
		StockResponse stockResponse = new StockResponse();
		stockResponse.setId(stock.getId());
		stockResponse.setShop(stock.getShop().getName());
		stockResponse.setGame(stock.getGame().getName());
		stockResponse.setUnits(stock.getUnits());
		return stockResponse;
	}

}
