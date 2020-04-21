package edu.stas.cursach.service.recipe.interfaces;

import edu.stas.cursach.model.Recipe;

import java.util.List;

public interface IRecipeService {
    Recipe save(Recipe recipe);
    Recipe edit(Recipe recipe);
    Recipe delete(String id);
    Recipe get(String id);
    List<Recipe> getAll();
}
