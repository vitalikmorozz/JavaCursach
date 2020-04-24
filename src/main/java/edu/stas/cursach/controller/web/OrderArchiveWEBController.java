package edu.stas.cursach.controller.web;

import edu.stas.cursach.model.*;
import edu.stas.cursach.service.order.impls.OrderServiceImpl;
import edu.stas.cursach.service.orderArchive.impls.OrderArchiveServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/web/orderArchive")
public class OrderArchiveWEBController {
    @Autowired
    OrderArchiveServiceImpl service;

    @Autowired
    OrderServiceImpl orderService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    String getAll(@RequestParam(required = false) String filter, @RequestParam(required = false) boolean sort, Model model) {
        List<OrderArchive> list;

        if(filter != null && !filter.isEmpty()) {
            list = service.findByRecipeId(filter);
        } else {
            list = service.getAll();
            filter = "";
        }

        model.addAttribute("orderArchives", list);
        model.addAttribute("filter", filter);
        model.addAttribute("sort", sort);
        return "listPages/orderArchiveList";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)

    String delete(@PathVariable("id") String id) {
        service.delete(id);
        return "redirect:/web/orderArchive/list";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    String create(Model model) {
        List<String> orderList = orderService.getAll().stream()
                .map(Order::getId).collect(Collectors.toList());

        model.addAttribute("orderArchive", new OrderArchive());
        model.addAttribute("orders", orderList);
        return "addPages/orderArchiveAdd";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    String create(@ModelAttribute("orderArchive") OrderArchive orderArchive) {
        service.save(orderArchive);
        return "redirect:/web/orderArchive/list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    String edit(Model model, @PathVariable("id") String id) {
        List<String> orderList = orderService.getAll().stream()
                .map(Order::getId).collect(Collectors.toList());

        OrderArchive orderArchive = service.get(id);

        model.addAttribute("orderArchive", orderArchive);
        model.addAttribute("orders", orderList);
        return "addPages/orderArchiveAdd";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    String edit(@PathVariable("id") String id, @ModelAttribute("orderArchive") OrderArchive orderArchive) {
        orderArchive.setId(id);
        service.save(orderArchive);
        return "redirect:/web/orderArchive/list";
    }
}
