package edu.stas.cursach.controller.web;

import edu.stas.cursach.model.Ingredient;
import edu.stas.cursach.service.ingredient.impls.IngredientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/web/ingredient")
public class IngredientWEBController {
    @Autowired
    IngredientServiceImpl service;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    String getAll(@RequestParam(required = false) String filter, @RequestParam(required = false) boolean sort, Model model) {
        List<Ingredient> list;

        if(filter != null && !filter.isEmpty()) {
            list = service.findByName(filter);
        } else {
            list = service.getAll();
            filter = "";
        }

        model.addAttribute("ingredients", list);
        model.addAttribute("filter", filter);
        model.addAttribute("sort", sort);
        return "listPages/ingredientList";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    String delete(@PathVariable("id") String id) {
        service.delete(id);
        return "redirect:/web/ingredient/list";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    String create(Model model) {
        model.addAttribute("ingredient", new Ingredient());
        return "addPages/ingredientAdd";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    String create(@ModelAttribute("ingredient") Ingredient ingredient) {
        service.save(ingredient);
        return "redirect:/web/ingredient/list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    String edit(Model model, @PathVariable("id") String id) {
        Ingredient ingredient = service.get(id);
        model.addAttribute("ingredient", ingredient);
        return "addPages/ingredientAdd";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    String edit(@PathVariable("id") String id, @ModelAttribute("ingredient") Ingredient ingredient) {
        ingredient.setId(id);
        service.save(ingredient);
        return "redirect:/web/ingredient/list";
    }
}
