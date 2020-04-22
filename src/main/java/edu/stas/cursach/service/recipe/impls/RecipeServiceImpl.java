package edu.stas.cursach.service.recipe.impls;

import edu.stas.cursach.dao.repository.RecipeRepository;
import edu.stas.cursach.model.Recipe;
import edu.stas.cursach.service.recipe.interfaces.IRecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class RecipeServiceImpl implements IRecipeService {
    @Autowired
    RecipeRepository repository;
    
    @PostConstruct
    void init() {
        List<Recipe> recipes = new ArrayList<>(Arrays.asList(
                new Recipe("1", LocalDateTime.now(), LocalDateTime.now(), "1", "1", "Headache", "1", 1),
                new Recipe("2", LocalDateTime.now(), LocalDateTime.now(), "2", "2", "Stomachache", "1", 2),
                new Recipe("3", LocalDateTime.now(), LocalDateTime.now(), "2", "1", "Holova bolit", "1", 3)
        ));

        repository.saveAll(recipes);
    };
    
    @Override
    public Recipe save(Recipe recipe) {
        recipe.setDateCreated(LocalDateTime.now());
        recipe.setDateModified(LocalDateTime.now());
        return repository.save(recipe);
    }

    @Override
    public Recipe edit(Recipe recipe) {
        recipe.setDateModified(LocalDateTime.now());
        return repository.save(recipe);
    }

    @Override
    public Recipe delete(String id) {
        Recipe recipe = repository.findById(id).orElse(null);
        repository.deleteById(id);
        return recipe;
    }

    @Override
    public Recipe get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Recipe> getAll() {
        return repository.findAll();
    }
}
