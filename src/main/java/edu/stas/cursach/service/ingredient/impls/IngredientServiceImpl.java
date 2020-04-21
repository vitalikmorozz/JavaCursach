package edu.stas.cursach.service.ingredient.impls;

import edu.stas.cursach.dao.repository.IngredientRepository;
import edu.stas.cursach.model.Ingredient;
import edu.stas.cursach.service.ingredient.interfaces.IIngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class IngredientServiceImpl implements IIngredientService {
    @Autowired
    IngredientRepository repository;
    
    @PostConstruct
    void init(){}
    
    @Override
    public Ingredient save(Ingredient ingredient) {
        ingredient.setDateCreated(LocalDateTime.now());
        ingredient.setDateModified(LocalDateTime.now());
        return repository.save(ingredient);
    }

    @Override
    public Ingredient edit(Ingredient ingredient) {
        ingredient.setDateModified(LocalDateTime.now());
        return repository.save(ingredient);
    }

    @Override
    public Ingredient delete(String id) {
        Ingredient ingredient = repository.findById(id).orElse(null);
        repository.deleteById(id);
        return ingredient;
    }

    @Override
    public Ingredient get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Ingredient> getAll() {
        return repository.findAll();
    }
}
