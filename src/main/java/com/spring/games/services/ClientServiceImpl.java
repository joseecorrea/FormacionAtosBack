package com.spring.games.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import com.spring.games.dto.request.ClientRequest;
import com.spring.games.dto.response.ClientResponse;
import com.spring.games.dto.response.GenericShortResponse;
import com.spring.games.entitys.Client;
import com.spring.games.exceptions.client.ClientIsAlreadySetException;
import com.spring.games.exceptions.client.ClientNotFoundException;
import com.spring.games.repositorys.ClientRepository;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	ClientRepository cR;
	
	@Autowired
	ConversionService cs;
	
	@Override
	public GenericShortResponse addClient(ClientRequest clientRequest) {
		Optional<Client> client = cR.findByDni(clientRequest.getDni()); 
		if(client.isEmpty()) {
			cR.save(cs.convert(clientRequest, Client.class));
		}else {
			throw new ClientIsAlreadySetException();
		}			
		return new GenericShortResponse("ok","ha sido añadido con exito");
	}

	@Override
	public ClientResponse getClient(String dni) {
		Optional<Client> client = cR.findByDni(dni);
		if (client.isPresent()) {
			return cs.convert(client.get(), ClientResponse.class);
		}else {
			throw new ClientNotFoundException();
		}
	}

}
