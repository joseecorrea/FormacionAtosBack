package com.spring.games.repositorys;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.games.entitys.Gender;

@Repository
public interface GenderRepository extends JpaRepository<Gender, Long>{

	public Optional<Gender> findByName(String name);
	
}
