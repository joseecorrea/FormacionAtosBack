package com.spring.games.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;

import com.spring.games.dto.request.ShopRequest;
import com.spring.games.entitys.Shop;
import com.spring.games.entitys.Stock;

public class ShopRequestToShopConverter implements Converter<ShopRequest,Shop>{

	@Override
	public Shop convert(ShopRequest shopRequest) {
		Shop shop = new Shop();
		List<Stock> stocks = new ArrayList<Stock>();
		shop.setName(shopRequest.getName());
		shop.setAddress(shopRequest.getAddress());
		shop.setZc(shopRequest.getZc());
		shop.setShopStocks(stocks);
		return shop;
	}

}
