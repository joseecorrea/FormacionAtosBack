package com.spring.games.services;

import java.util.List;
import java.util.Optional;

import com.spring.games.entitys.Game;
import com.spring.games.entitys.Gender;
import com.spring.games.enums.GenreEnum;

public interface GenderService {
	
	public Optional<Gender> getGender(String name);
	
	public void ifExistAssociate(GenreEnum genderEnum,List<Gender> genderlist,Game game);
	
	public void addNewGendersBD();
	
}
