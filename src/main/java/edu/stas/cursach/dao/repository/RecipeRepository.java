package edu.stas.cursach.dao.repository;

import edu.stas.cursach.model.Recipe;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RecipeRepository extends MongoRepository<Recipe, String> {
}
