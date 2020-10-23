package com.spring.games.converter;

import org.springframework.core.convert.converter.Converter;

import com.spring.games.dto.request.ClientRequest;
import com.spring.games.entitys.Client;

public class ClientRequestToClientConverter implements Converter<ClientRequest, Client>{

	@Override
	public Client convert(ClientRequest source) {
		Client client = new Client();
		client.setDni(source.getDni());
		client.setLastName(source.getLastName());
		client.setName(source.getName());
		return client;
	}

}
