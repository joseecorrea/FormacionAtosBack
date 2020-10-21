package com.spring.games.services;

import java.util.Optional;

import com.spring.games.dto.request.ShopRequest;
import com.spring.games.dto.response.GenericShortResponse;
import com.spring.games.dto.response.ShopResponse;
import com.spring.games.entitys.Shop;

public interface ShopService {
	
	public GenericShortResponse addShop(ShopRequest shopRequest);
	
	public ShopResponse getShop(String name);
	
	public Optional<Shop> getShop(Long id);
}
