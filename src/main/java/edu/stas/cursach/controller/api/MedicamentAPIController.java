package edu.stas.cursach.controller.api;

import edu.stas.cursach.model.Medicament;
import edu.stas.cursach.service.medicament.impls.MedicamentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medicament")
public class MedicamentAPIController {
    @Autowired
    MedicamentServiceImpl service;

    @RequestMapping(value = "/get/list", method = RequestMethod.GET)
    List<Medicament> getAll() {
        return service.getAll();
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    Medicament getById(@PathVariable("id") String id) {
        return service.get(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    Medicament create(@RequestBody Medicament medicament) {
        return service.save(medicament);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    Medicament edit(@RequestBody Medicament medicament) {
        return service.save(medicament);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    Medicament delete(@PathVariable("id") String id) {
        return service.delete(id);
    }
}
