package edu.stas.cursach.service.ingredient.interfaces;

import edu.stas.cursach.model.Ingredient;

import java.util.List;

public interface IIngredientService {
    Ingredient save(Ingredient ingredient);
    Ingredient edit(Ingredient ingredient);
    Ingredient delete(String id);
    Ingredient get(String id);
    List<Ingredient> getAll();
}
