package edu.stas.cursach.controller.api;

import edu.stas.cursach.model.MedicamentUsage;
import edu.stas.cursach.service.medicamentUsage.impls.MedicamentUsageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medicamentUsage")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MedicamentUsageAPIController {
    @Autowired
    MedicamentUsageServiceImpl service;

    @RequestMapping(value = "/get/list", method = RequestMethod.GET)
    List<MedicamentUsage> getAll() {
        return service.getAll();
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    MedicamentUsage getById(@PathVariable("id") String id) {
        return service.get(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    MedicamentUsage create(@RequestBody MedicamentUsage medicamentUsage) {
        return service.save(medicamentUsage);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    MedicamentUsage edit(@RequestBody MedicamentUsage medicamentUsage) {
        return service.save(medicamentUsage);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    MedicamentUsage delete(@PathVariable("id") String id) {
        return service.delete(id);
    }
}
