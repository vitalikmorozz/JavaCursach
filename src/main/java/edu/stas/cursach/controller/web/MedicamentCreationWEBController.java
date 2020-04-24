package edu.stas.cursach.controller.web;

import edu.stas.cursach.model.Ingredient;
import edu.stas.cursach.model.MedicamentCreation;
import edu.stas.cursach.service.ingredient.impls.IngredientServiceImpl;
import edu.stas.cursach.service.medicamentCreation.impls.MedicamentCreationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/web/medicamentCreation")
public class MedicamentCreationWEBController {
    @Autowired
    MedicamentCreationServiceImpl service;

    @Autowired
    IngredientServiceImpl ingredientService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    String getAll(Model model) {
        model.addAttribute("medicamentCreations", service.getAll());
        return "listPages/medicamentCreationList";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    String delete(@PathVariable("id") String id) {
        service.delete(id);
        return "redirect:/web/medicamentCreation/list";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    String create(Model model) {
        Map<String, String> ingredients = ingredientService.getAll().stream()
                .collect(Collectors.toMap(Ingredient::getId, Ingredient::getName));

        model.addAttribute("medicamentCreation", new MedicamentCreation());
        model.addAttribute("ingredients", ingredients);
        return "addPages/medicamentCreationAdd";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    String create(@ModelAttribute("medicamentCreation") MedicamentCreation medicamentCreation) {
        service.save(medicamentCreation);
        return "redirect:/web/medicamentCreation/list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    String edit(Model model, @PathVariable("id") String id) {
        Map<String, String> ingredients = ingredientService.getAll().stream()
                .collect(Collectors.toMap(Ingredient::getId, Ingredient::getName));

        MedicamentCreation medicamentCreation = service.get(id);

        model.addAttribute("medicamentCreation", medicamentCreation);
        model.addAttribute("ingredients", ingredients);
        return "addPages/medicamentCreationAdd";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    String edit(@PathVariable("id") String id, @ModelAttribute("medicamentCreation") MedicamentCreation medicamentCreation) {
        medicamentCreation.setId(id);
        service.save(medicamentCreation);
        return "redirect:/web/medicamentCreation/list";
    }
}
