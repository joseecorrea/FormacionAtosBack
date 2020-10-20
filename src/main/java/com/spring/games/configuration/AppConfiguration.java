package com.spring.games.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import com.spring.games.converter.GameRequestToGameConverter;
import com.spring.games.converter.GameToGameResponseConverter;
import com.spring.games.converter.GameToGameResponseShortConverter;
import com.spring.games.converter.GenderEnumToGenderConverter;
import com.spring.games.converter.GenderToGenderResponseConverter;
import com.spring.games.converter.ShopRequestToShopConverter;
import com.spring.games.converter.ShopToShopResponseConverter;


@Configuration
public class AppConfiguration implements WebMvcConfigurer  {

	public void addFormatters(FormatterRegistry registry) {
		registry.addConverter(new GameRequestToGameConverter());
		registry.addConverter(new GameToGameResponseConverter());
		registry.addConverter(new GameToGameResponseShortConverter());
		registry.addConverter(new GenderEnumToGenderConverter());
		registry.addConverter(new GenderToGenderResponseConverter());
		registry.addConverter(new ShopRequestToShopConverter());
		registry.addConverter(new ShopToShopResponseConverter());
	}
	
}
