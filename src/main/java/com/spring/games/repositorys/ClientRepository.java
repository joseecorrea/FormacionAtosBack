package com.spring.games.repositorys;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.games.entitys.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

	public Optional<Client> findByDni(String dni);
}
