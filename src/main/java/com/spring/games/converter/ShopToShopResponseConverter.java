package com.spring.games.converter;

import org.springframework.core.convert.converter.Converter;

import com.spring.games.dto.response.ShopResponse;
import com.spring.games.entitys.Shop;

public class ShopToShopResponseConverter implements Converter<Shop, ShopResponse>{

	@Override
	public ShopResponse convert(Shop shop) {
		ShopResponse shopResponse = new ShopResponse();
		shopResponse.setId(shop.getId());
		shopResponse.setName(shop.getName());
		shopResponse.setAddress(shop.getAddress());
		shopResponse.setZc(shop.getZc());
		return shopResponse;
	}

}
