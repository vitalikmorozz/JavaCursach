package edu.stas.cursach.controller.api;

import edu.stas.cursach.model.MedicamentType;
import edu.stas.cursach.service.medicamentType.impls.MedicamentTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medicamentType")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MedicamentTypeAPIController {
    @Autowired
    MedicamentTypeServiceImpl service;

    @RequestMapping(value = "/get/list", method = RequestMethod.GET)
    List<MedicamentType> getAll() {
        return service.getAll();
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    MedicamentType getById(@PathVariable("id") String id) {
        return service.get(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    MedicamentType create(@RequestBody MedicamentType medicamentType) {
        return service.save(medicamentType);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    MedicamentType edit(@RequestBody MedicamentType medicamentType) {
        return service.save(medicamentType);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    MedicamentType delete(@PathVariable("id") String id) {
        return service.delete(id);
    }
}
