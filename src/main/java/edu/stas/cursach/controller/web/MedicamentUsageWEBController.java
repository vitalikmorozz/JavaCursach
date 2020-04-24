package edu.stas.cursach.controller.web;

import edu.stas.cursach.model.MedicamentUsage;
import edu.stas.cursach.service.medicamentUsage.impls.MedicamentUsageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/web/medicamentUsage")
public class MedicamentUsageWEBController {
    @Autowired
    MedicamentUsageServiceImpl service;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    String getAll(@RequestParam(required = false) String filter, @RequestParam(required = false) boolean sort, Model model) {
        List<MedicamentUsage> list;

        if(filter != null && !filter.isEmpty()) {
            list = service.findByName(filter);
        } else {
            list = service.getAll();
            filter = "";
        }

        model.addAttribute("medicamentUsages", list);
        model.addAttribute("filter", filter);
        model.addAttribute("sort", sort);
        return "listPages/medicamentUsageList";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    String delete(@PathVariable("id") String id) {
        service.delete(id);
        return "redirect:/web/medicamentUsage/list";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    String create(Model model) {
        model.addAttribute("medicamentUsage", new MedicamentUsage());
        return "addPages/medicamentUsageAdd";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    String create(@ModelAttribute("medicamentUsage") MedicamentUsage medicamentUsage) {
        service.save(medicamentUsage);
        return "redirect:/web/medicamentUsage/list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    String edit(Model model, @PathVariable("id") String id) {
        MedicamentUsage medicamentUsage = service.get(id);
        model.addAttribute("medicamentUsage", medicamentUsage);
        return "addPages/medicamentUsageAdd";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    String edit(@PathVariable("id") String id, @ModelAttribute("medicamentUsage") MedicamentUsage medicamentUsage) {
        medicamentUsage.setId(id);
        service.save(medicamentUsage);
        return "redirect:/web/medicamentUsage/list";
    }
}
