package com.spring.games.services;

import com.spring.games.dto.request.ShopRequest;
import com.spring.games.dto.response.GenericShortResponse;
import com.spring.games.dto.response.ShopResponse;

public interface ShopService {
	
	public GenericShortResponse addShop(ShopRequest shopRequest);
	
	public ShopResponse getShop(String name);
}
