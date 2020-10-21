package com.spring.games.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import com.spring.games.dto.request.ShopRequest;
import com.spring.games.dto.response.GenericShortResponse;
import com.spring.games.dto.response.ShopResponse;
import com.spring.games.entitys.Shop;
import com.spring.games.exceptions.generic.IsAlreadySetExeption;
import com.spring.games.exceptions.generic.NotFoundException;
import com.spring.games.exceptions.shop.ShopIsAlreadySetException;
import com.spring.games.exceptions.shop.ShopNotFoundException;
import com.spring.games.repositorys.ShopRepository;

@Service
public class ShopServiceImpl implements ShopService {

	@Autowired
	ShopRepository shopRepository;
	
	@Autowired
	ConversionService cs;
	
	@Override
	public GenericShortResponse addShop(ShopRequest shopRequest) {
		Optional<Shop> shopO = shopRepository.findByName(shopRequest.getName());
		GenericShortResponse respuesta = new GenericShortResponse();
		if(shopO.isEmpty()) {
			Shop shop = cs.convert(shopRequest, Shop.class);
			shopRepository.save(shop);	
			respuesta.setName(shop.getName());
			respuesta.setMessage("ha sido añadido");
		}else {
			throw new ShopIsAlreadySetException();
		}
		return respuesta;
	}

	@Override
	public ShopResponse getShop(String name) {
		Optional<Shop> shopO = shopRepository.findByName(name);
		if(shopO.isPresent()) {
			ShopResponse shopResponse = cs.convert(shopO.get(), ShopResponse.class);	
			return shopResponse;
		}else {
			throw new ShopNotFoundException();
		}				
	}

	@Override
	public Optional<Shop> getShop(Long id) {
		return shopRepository.findById(id);
	}

}
