package edu.stas.cursach.controller.web;

import edu.stas.cursach.model.MedicamentType;
import edu.stas.cursach.service.medicamentType.impls.MedicamentTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/web/medicamentType")
public class MedicamentTypeWEBController {
    @Autowired
    MedicamentTypeServiceImpl service;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    String getAll(@RequestParam(required = false) String filter, @RequestParam(required = false) boolean sort, Model model) {
        List<MedicamentType> list;

        if(filter != null && !filter.isEmpty()) {
            list = service.findByName(filter);
        } else {
            list = service.getAll();
            filter = "";
        }

        model.addAttribute("medicamentTypes", list);
        model.addAttribute("filter", filter);
        model.addAttribute("sort", sort);
        return "listPages/medicamentTypeList";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    String delete(@PathVariable("id") String id) {
        service.delete(id);
        return "redirect:/web/medicamentType/list";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    String create(Model model) {
        model.addAttribute("medicamentType", new MedicamentType());
        return "addPages/medicamentTypeAdd";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    String create(@ModelAttribute("medicamentType") MedicamentType medicamentType) {
        service.save(medicamentType);
        return "redirect:/web/medicamentType/list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    String edit(Model model, @PathVariable("id") String id) {
        MedicamentType medicamentType = service.get(id);
        model.addAttribute("medicamentType", medicamentType);
        return "addPages/medicamentTypeAdd";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    String edit(@PathVariable("id") String id, @ModelAttribute("medicamentType") MedicamentType medicamentType) {
        medicamentType.setId(id);
        service.save(medicamentType);
        return "redirect:/web/medicamentType/list";
    }
}
