package edu.stas.cursach.dao.repository;

import edu.stas.cursach.model.OrderArchive;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderArchiveRepository extends MongoRepository<OrderArchive, String> {
}
