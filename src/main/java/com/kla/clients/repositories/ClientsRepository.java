package com.kla.clients.repositories;

import com.kla.clients.entities.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientsRepository extends CrudRepository<Client,Long> {
}
