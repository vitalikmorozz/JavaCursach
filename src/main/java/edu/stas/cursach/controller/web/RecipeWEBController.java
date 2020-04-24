package edu.stas.cursach.controller.web;

import edu.stas.cursach.model.Client;
import edu.stas.cursach.model.Doctor;
import edu.stas.cursach.model.Medicament;
import edu.stas.cursach.model.Recipe;
import edu.stas.cursach.service.client.impls.ClientServiceImpl;
import edu.stas.cursach.service.doctor.impls.DoctorServiceImpl;
import edu.stas.cursach.service.medicament.impls.MedicamentServiceImpl;
import edu.stas.cursach.service.recipe.impls.RecipeServiceImpl;
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
@RequestMapping("/web/recipe")
public class RecipeWEBController {
    @Autowired
    RecipeServiceImpl service;

    @Autowired
    DoctorServiceImpl doctorService;

    @Autowired
    ClientServiceImpl clientService;

    @Autowired
    MedicamentServiceImpl medicamentService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    String getAll(Model model) {
        model.addAttribute("recipes", service.getAll());
        return "listPages/recipeList";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    String delete(@PathVariable("id") String id) {
        service.delete(id);
        return "redirect:/web/recipe/list";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    String create(Model model) {
        Map<String, String> doctorMap = doctorService.getAll().stream()
                .collect(Collectors.toMap(Doctor::getId, Doctor::getName));

        Map<String, String> clientMap = clientService.getAll().stream()
                .collect(Collectors.toMap(Client::getId, Client::getName));

        Map<String, String> medicamentMap = medicamentService.getAll().stream()
                .collect(Collectors.toMap(Medicament::getId, Medicament::getName));

        model.addAttribute("recipe", new Recipe());
        model.addAttribute("doctors", doctorMap);
        model.addAttribute("clients", clientMap);
        model.addAttribute("medicaments", medicamentMap);
        return "addPages/recipeAdd";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    String create(@ModelAttribute("recipe") Recipe recipe) {
        service.save(recipe);
        return "redirect:/web/recipe/list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    String edit(Model model, @PathVariable("id") String id) {
        Map<String, String> doctorMap = doctorService.getAll().stream()
                .collect(Collectors.toMap(Doctor::getId, Doctor::getName));

        Map<String, String> clientMap = clientService.getAll().stream()
                .collect(Collectors.toMap(Client::getId, Client::getName));

        Map<String, String> medicamentMap = medicamentService.getAll().stream()
                .collect(Collectors.toMap(Medicament::getId, Medicament::getName));

        Recipe recipe = service.get(id);

        model.addAttribute("recipe", recipe);
        model.addAttribute("doctors", doctorMap);
        model.addAttribute("clients", clientMap);
        model.addAttribute("medicaments", medicamentMap);
        return "addPages/recipeAdd";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    String edit(@PathVariable("id") String id, @ModelAttribute("recipe") Recipe recipe) {
        recipe.setId(id);
        service.save(recipe);
        return "redirect:/web/recipe/list";
    }
}
