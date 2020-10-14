package com.spring.games.converter;

import org.springframework.core.convert.converter.Converter;

import com.spring.games.dto.response.GenderResponse;
import com.spring.games.entitys.Gender;

public class GenderToGenderResponseConverter implements Converter<Gender, GenderResponse>{

	@Override
	public GenderResponse convert(Gender gender) {
		GenderResponse genderResponse = new GenderResponse();
		genderResponse.setId(gender.getId());
		genderResponse.setName(gender.getName());
		return genderResponse;
	}

}
