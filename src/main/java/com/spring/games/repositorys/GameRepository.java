package com.spring.games.repositorys;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.games.entitys.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
	
	public Optional<Game> findByName(String name);
	
}
