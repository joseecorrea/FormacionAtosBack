package com.spring.games.services;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import com.spring.games.entitys.Game;
import com.spring.games.entitys.Gender;
import com.spring.games.enums.GenreEnum;
import com.spring.games.repositorys.GenderRepository;

@Service
public class GenderServiceImpl implements GenderService{

	@Autowired
	GenderRepository genderRepository;
	
	@Autowired
	ConversionService cs;
	
	@Override
	public Optional<Gender> getGender(String name) {		
		return genderRepository.findByName(name);
	}

	@Override
	public void ifExistAssociate(GenreEnum genderEnum, List<Gender> genderlist,Game game) {
		Optional<Gender> genderO = getGender(genderEnum.name());
		if(genderO.isPresent()) {
			Gender gender = genderO.get();
			gender.getGames().add(game);
			genderlist.add(gender);
		}
	}

	@Override
	@PostConstruct
	public void addNewGendersBD() {
		GenreEnum[] enumArray = GenreEnum.values();
		for(GenreEnum genreEnum:enumArray) {
			Optional<Gender> genderO = getGender(genreEnum.name());
			if(genderO.isEmpty()) {
				genderRepository.save(cs.convert(genreEnum, Gender.class));
			}
		}
	}

}
