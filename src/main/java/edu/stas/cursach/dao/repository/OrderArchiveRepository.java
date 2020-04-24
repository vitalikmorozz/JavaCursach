package edu.stas.cursach.dao.repository;

import edu.stas.cursach.model.OrderArchive;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface OrderArchiveRepository extends MongoRepository<OrderArchive, String> {
    List<OrderArchive> findOrderArchiveByOrderId(String id);
}
