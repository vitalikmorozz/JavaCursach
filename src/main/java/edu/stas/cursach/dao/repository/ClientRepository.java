package edu.stas.cursach.dao.repository;

import edu.stas.cursach.model.Client;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClientRepository extends MongoRepository<Client, String> {
}
