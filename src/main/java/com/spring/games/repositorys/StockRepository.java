package com.spring.games.repositorys;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.games.entitys.Game;
import com.spring.games.entitys.Shop;
import com.spring.games.entitys.Stock;

public interface StockRepository extends JpaRepository<Stock, Long>{
	
	public Optional<Stock> findByShopAndGame(Shop shop,Game game);
	
}
