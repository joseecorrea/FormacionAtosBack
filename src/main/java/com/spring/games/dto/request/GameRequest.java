package com.spring.games.dto.request;

import java.math.BigDecimal;
import java.util.ArrayList;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.spring.games.enums.GenreEnum;
import lombok.Data;


@Data
public class GameRequest {

	@NotBlank(message = "Nombre de la pelicula obligatorio")
	private String name;
	
	@Size(message = "Necesita minimo un genero",min=1)
	private ArrayList<GenreEnum> gameGenders;
	
	@NotNull(message = "Es necesaria un puntuacion")
	private BigDecimal rating;
	
	@NotNull(message = "Es necesario un precio")
	private BigDecimal price;

}
