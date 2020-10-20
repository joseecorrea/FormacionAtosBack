package com.spring.games.repositorys;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.games.entitys.Shop;

public interface ShopRepository extends JpaRepository<Shop,Long>{

	public Optional<Shop> findByName(String name);
	
}
