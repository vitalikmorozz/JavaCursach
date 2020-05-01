package edu.stas.cursach.controller.api;

import edu.stas.cursach.model.Ingredient;
import edu.stas.cursach.service.ingredient.impls.IngredientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ingredient")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class IngredientAPIController {
    @Autowired
    IngredientServiceImpl service;

    @RequestMapping(value = "/get/list", method = RequestMethod.GET)
    List<Ingredient> getAll() {
        return service.getAll();
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    Ingredient getById(@PathVariable("id") String id) {
        return service.get(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    Ingredient create(@RequestBody Ingredient ingredient) {
        return service.save(ingredient);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    Ingredient edit(@RequestBody Ingredient ingredient) {
        return service.save(ingredient);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    Ingredient delete(@PathVariable("id") String id) {
        return service.delete(id);
    }
}
