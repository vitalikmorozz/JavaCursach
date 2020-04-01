package edu.stas.cursach.dao.repository;

import edu.stas.cursach.model.Ingredient;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IngredientsRepository extends MongoRepository<Ingredient, String> {
}
