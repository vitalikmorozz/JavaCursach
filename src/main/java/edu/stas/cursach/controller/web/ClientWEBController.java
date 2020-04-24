package edu.stas.cursach.controller.web;

import edu.stas.cursach.model.Client;
import edu.stas.cursach.service.client.impls.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/web/client")
public class ClientWEBController {
    @Autowired
    ClientServiceImpl service;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    String getAll(@RequestParam(required = false) String filter, @RequestParam(required = false) boolean sort, Model model) {
        List<Client> list;

        if(filter != null && !filter.isEmpty()) {
            list = service.findByName(filter);
        } else {
            list = service.getAll();
            filter = "";
        }

        model.addAttribute("clients", list);
        model.addAttribute("filter", filter);
        model.addAttribute("sort", sort);
        return "listPages/clientList";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    String delete(@PathVariable("id") String id) {
        service.delete(id);
        return "redirect:/web/client/list";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    String create(Model model) {
        model.addAttribute("client", new Client());
        return "addPages/clientAdd";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    String create(@ModelAttribute("client") Client client) {
        service.save(client);
        return "redirect:/web/client/list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    String edit(Model model, @PathVariable("id") String id) {
        Client client = service.get(id);
        model.addAttribute("client", client);
        return "addPages/clientAdd";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    String edit(@PathVariable("id") String id, @ModelAttribute("client") Client client) {
        client.setId(id);
        service.save(client);
        return "redirect:/web/client/list";
    }
}
