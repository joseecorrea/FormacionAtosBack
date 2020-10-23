package com.spring.games.services;

import com.spring.games.dto.request.ClientRequest;
import com.spring.games.dto.response.ClientResponse;
import com.spring.games.dto.response.GenericShortResponse;

public interface ClientService {
	
	public GenericShortResponse addClient(ClientRequest clientRequest);
	
	public ClientResponse getClient(String dni);
}
