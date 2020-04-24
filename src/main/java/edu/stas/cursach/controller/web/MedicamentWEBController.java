package edu.stas.cursach.controller.web;

import edu.stas.cursach.model.Medicament;
import edu.stas.cursach.model.MedicamentCreation;
import edu.stas.cursach.model.MedicamentType;
import edu.stas.cursach.model.MedicamentUsage;
import edu.stas.cursach.service.medicament.impls.MedicamentServiceImpl;
import edu.stas.cursach.service.medicamentCreation.impls.MedicamentCreationServiceImpl;
import edu.stas.cursach.service.medicamentType.impls.MedicamentTypeServiceImpl;
import edu.stas.cursach.service.medicamentUsage.impls.MedicamentUsageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/web/medicament")
public class MedicamentWEBController {
    @Autowired
    MedicamentServiceImpl service;

    @Autowired
    MedicamentTypeServiceImpl typeService;

    @Autowired
    MedicamentUsageServiceImpl usageService;

    @Autowired
    MedicamentCreationServiceImpl creationService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    String getAll(@RequestParam(required = false) String filter, @RequestParam(required = false) boolean sort, Model model) {
        List<Medicament> list;

        if(filter != null && !filter.isEmpty()) {
            list = service.findByName(filter);
        } else {
            list = service.getAll();
            filter = "";
        }

        model.addAttribute("medicaments", list);
        model.addAttribute("filter", filter);
        model.addAttribute("sort", sort);
        return "listPages/medicamentList";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    String delete(@PathVariable("id") String id) {
        service.delete(id);
        return "redirect:/web/medicament/list";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    String create(Model model) {
        Map<String, String> typeMap = typeService.getAll().stream()
                .collect(Collectors.toMap(MedicamentType::getId, MedicamentType::getName));

        Map<String, String> usageMap = usageService.getAll().stream()
                .collect(Collectors.toMap(MedicamentUsage::getId, MedicamentUsage::getName));

        Map<String, String> creationMap = creationService.getAll().stream()
                .collect(Collectors.toMap(MedicamentCreation::getId, MedicamentCreation::getName));

        model.addAttribute("medicament", new Medicament());
        model.addAttribute("types", typeMap);
        model.addAttribute("usages", usageMap);
        model.addAttribute("creations", creationMap);
        return "addPages/medicamentAdd";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    String create(@ModelAttribute("medicament") Medicament medicament) {
        service.save(medicament);
        return "redirect:/web/medicament/list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    String edit(Model model, @PathVariable("id") String id) {
        Map<String, String> typeMap = typeService.getAll().stream()
                .collect(Collectors.toMap(MedicamentType::getId, MedicamentType::getName));

        Map<String, String> usageMap = usageService.getAll().stream()
                .collect(Collectors.toMap(MedicamentUsage::getId, MedicamentUsage::getName));

        Map<String, String> creationMap = creationService.getAll().stream()
                .collect(Collectors.toMap(MedicamentCreation::getId, MedicamentCreation::getName));

        Medicament medicament = service.get(id);

        model.addAttribute("medicament", medicament);
        model.addAttribute("types", typeMap);
        model.addAttribute("usages", usageMap);
        model.addAttribute("creations", creationMap);
        return "addPages/medicamentAdd";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    String edit(@PathVariable("id") String id, @ModelAttribute("medicament") Medicament medicament) {
        medicament.setId(id);
        service.save(medicament);
        return "redirect:/web/medicament/list";
    }
}
