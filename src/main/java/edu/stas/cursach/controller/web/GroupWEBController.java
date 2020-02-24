package edu.stas.cursach.controller.web;

import edu.stas.cursach.model.Group;
import edu.stas.cursach.service.group.impls.GroupServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        return "groupList";
    }
}
