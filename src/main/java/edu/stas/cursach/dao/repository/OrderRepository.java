package edu.stas.cursach.dao.repository;

import edu.stas.cursach.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface OrderRepository extends MongoRepository<Order, String> {
    List<Order> findOrdersByRecipeId(String id);
}
