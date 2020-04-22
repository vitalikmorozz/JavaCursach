package edu.stas.cursach.controller.api;

import edu.stas.cursach.model.Recipe;
import edu.stas.cursach.service.recipe.impls.RecipeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recipe")
public class RecipeAPIController {
    @Autowired
    RecipeServiceImpl service;

    @RequestMapping(value = "/get/list", method = RequestMethod.GET)
    List<Recipe> getAll() {
        return service.getAll();
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    Recipe getById(@PathVariable("id") String id) {
        return service.get(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    Recipe create(@RequestBody Recipe recipe) {
        return service.save(recipe);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    Recipe edit(@RequestBody Recipe recipe) {
        return service.save(recipe);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    Recipe delete(@PathVariable("id") String id) {
        return service.delete(id);
    }
}
