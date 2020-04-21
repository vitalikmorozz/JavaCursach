package edu.stas.cursach.service.recipe.impls;

import edu.stas.cursach.dao.repository.RecipeRepository;
import edu.stas.cursach.model.Recipe;
import edu.stas.cursach.service.recipe.interfaces.IRecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class RecipeServiceImpl implements IRecipeService {
    @Autowired
    RecipeRepository repository;
    
    @PostConstruct
    void init() {};
    
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
