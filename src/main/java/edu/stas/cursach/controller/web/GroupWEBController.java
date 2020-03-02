package edu.stas.cursach.controller.web;

import edu.stas.cursach.form.GroupForm;
import edu.stas.cursach.model.Group;
import edu.stas.cursach.service.group.impls.GroupServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/web/group")
public class GroupWEBController {
    @Autowired
    GroupServiceImpl service;

    @RequestMapping("/list")
    String getAll(Model model) {
        model.addAttribute("groups", service.getAll());
        return "groupList";
    }

    @RequestMapping("/delete/{id}")
    String delete(Model model,
                  @PathVariable("id") String id) {
        service.delete(id);
        model.addAttribute("groups", service.getAll());
        return "redirect:/web/group/list";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    String create(Model model) {
        GroupForm groupForm = new GroupForm();
        model.addAttribute("groupForm", groupForm);
        return "groupAdd";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    String create(Model model, @ModelAttribute("groupForm") GroupForm groupForm) {
        Group group = new Group();
        group.setName(groupForm.getName());
        group.setDescription(groupForm.getDescription());
        service.save(group);
        model.addAttribute("groups", service.getAll());
        return "redirect:/web/group/list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    String edit(Model model, @PathVariable("id") String id) {
        Group group = service.get(id);
        GroupForm groupForm = new GroupForm();
        groupForm.setName(group.getName());
        groupForm.setDescription(group.getDescription());
        model.addAttribute("groupForm", groupForm);
        return "groupAdd";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    String edit(Model model, @PathVariable("id") String id, @ModelAttribute("groupForm") GroupForm groupForm) {
        Group group = new Group();
        group.setId(id);
        group.setName(groupForm.getName());
        group.setDescription(groupForm.getDescription());
        service.save(group);
        model.addAttribute("groups", service.getAll());
        return "redirect:/web/group/list";
    }
}
