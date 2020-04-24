package edu.stas.cursach.dao.repository;

import edu.stas.cursach.model.Ingredient;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface IngredientRepository extends MongoRepository<Ingredient, String> {
    List<Ingredient> findIngredientsByName(String name);
}
