package com.spring.games.converter;

import org.springframework.core.convert.converter.Converter;

import com.spring.games.dto.response.ClientResponse;
import com.spring.games.entitys.Client;

public class ClientToClientResponseConverter implements Converter<Client, ClientResponse> {

	@Override
	public ClientResponse convert(Client source) {
		ClientResponse clientResponse = new ClientResponse();
		clientResponse.setId(source.getId());
		clientResponse.setDni(source.getDni());
		clientResponse.setLastName(source.getLastName());
		clientResponse.setName(source.getName());
		return clientResponse;
	}

}
