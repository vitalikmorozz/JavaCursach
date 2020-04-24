package edu.stas.cursach.controller.web;

import edu.stas.cursach.model.Order;
import edu.stas.cursach.model.Recipe;
import edu.stas.cursach.service.order.impls.OrderServiceImpl;
import edu.stas.cursach.service.recipe.impls.RecipeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/web/order")
public class OrderWEBController {
    @Autowired
    OrderServiceImpl service;

    @Autowired
    RecipeServiceImpl recipeService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    String getAll(@RequestParam(required = false) String filter, @RequestParam(required = false) boolean sort, Model model) {
        List<Order> list;

        if(filter != null && !filter.isEmpty()) {
            list = service.findByRecipeId(filter);
        } else {
            list = service.getAll();
            filter = "";
        }

        model.addAttribute("orders", list);
        model.addAttribute("filter", filter);
        model.addAttribute("sort", sort);
        return "listPages/orderList";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    String delete(@PathVariable("id") String id) {
        service.delete(id);
        return "redirect:/web/order/list";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    String create(Model model) {
        List<String> recipes = recipeService.getAll().stream()
                .map(Recipe::getId).collect(Collectors.toList());

        model.addAttribute("order", new Order());
        model.addAttribute("recipes", recipes);
        return "addPages/orderAdd";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    String create(@ModelAttribute("order") Order order) {
        service.save(order);
        return "redirect:/web/order/list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    String edit(Model model, @PathVariable("id") String id) {
        List<String> recipes = recipeService.getAll().stream()
                .map(Recipe::getId).collect(Collectors.toList());

        Order order = service.get(id);
        model.addAttribute("order", order);
        model.addAttribute("recipes", recipes);
        return "addPages/orderAdd";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    String edit(@PathVariable("id") String id, @ModelAttribute("order") Order order) {
        order.setId(id);
        service.save(order);
        return "redirect:/web/order/list";
    }    
}
