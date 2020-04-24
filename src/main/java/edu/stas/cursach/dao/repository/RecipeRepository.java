package edu.stas.cursach.dao.repository;

import edu.stas.cursach.model.Recipe;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RecipeRepository extends MongoRepository<Recipe, String> {
    List<Recipe> findRecipesByDoctorId(String id);
}
