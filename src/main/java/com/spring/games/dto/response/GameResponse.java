package com.spring.games.dto.response;

import java.math.BigDecimal;
import java.util.List;
import com.spring.games.enums.GenreEnum;
import lombok.Data;

@Data
public class GameResponse {

	private Long id;

	private String name;

	private List<GenderResponse> gameGenders;

	private BigDecimal rating;

	private BigDecimal price;
	
}
