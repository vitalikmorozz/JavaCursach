package edu.stas.cursach.dao.repository;

import edu.stas.cursach.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order, String> {
}
