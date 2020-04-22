package edu.stas.cursach.controller.api;

import edu.stas.cursach.model.MedicamentCreation;
import edu.stas.cursach.service.medicamentCreation.impls.MedicamentCreationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medicamentCreation")
public class MedicamentCreationAPIController {
    @Autowired
    MedicamentCreationServiceImpl service;

    @RequestMapping(value = "/get/list", method = RequestMethod.GET)
    List<MedicamentCreation> getAll() {
        return service.getAll();
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    MedicamentCreation getById(@PathVariable("id") String id) {
        return service.get(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    MedicamentCreation create(@RequestBody MedicamentCreation medicamentCreation) {
        return service.save(medicamentCreation);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    MedicamentCreation edit(@RequestBody MedicamentCreation medicamentCreation) {
        return service.save(medicamentCreation);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    MedicamentCreation delete(@PathVariable("id") String id) {
        return service.delete(id);
    }
}
