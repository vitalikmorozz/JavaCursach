package edu.stas.cursach.controller.web;

import edu.stas.cursach.model.Group;
import edu.stas.cursach.service.group.impls.GroupServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/web/group")
public class GroupWEBController {
    @Autowired
    GroupServiceImpl service;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    String getAll(Model model) {
        model.addAttribute("groups", service.getAll());
        return "listPages/groupList";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    String delete(@PathVariable("id") String id) {
        service.delete(id);
        return "redirect:/web/group/list";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    String create(Model model) {
        model.addAttribute("group", new Group());
        return "addPages/groupAdd";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    String create(@ModelAttribute("group") Group group) {
        service.save(group);
        return "redirect:/web/group/list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    String edit(Model model, @PathVariable("id") String id) {
        Group group = service.get(id);
        model.addAttribute("group", group);
        return "addPages/groupAdd";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    String edit(@PathVariable("id") String id, @ModelAttribute("group") Group group) {
        group.setId(id);
        service.save(group);
        return "redirect:/web/group/list";
    }
}
