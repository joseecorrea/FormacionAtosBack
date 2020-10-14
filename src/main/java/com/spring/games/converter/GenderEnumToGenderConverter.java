package com.spring.games.converter;

import org.springframework.core.convert.converter.Converter;

import com.spring.games.entitys.Gender;
import com.spring.games.enums.GenreEnum;

public class GenderEnumToGenderConverter implements Converter<GenreEnum, Gender>{

	@Override
	public Gender convert(GenreEnum genderEnum) {
		Gender gender = new Gender();
		gender.setName(genderEnum.name());
		return gender;
	}

}
