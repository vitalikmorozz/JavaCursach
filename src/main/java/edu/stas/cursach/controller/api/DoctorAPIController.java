package edu.stas.cursach.controller.api;

import edu.stas.cursach.model.Doctor;
import edu.stas.cursach.service.doctor.impls.DoctorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctor")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DoctorAPIController {
    @Autowired
    DoctorServiceImpl service;

    @RequestMapping(value = "/get/list", method = RequestMethod.GET)
    List<Doctor> getAll() {
        return service.getAll();
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    Doctor getById(@PathVariable("id") String id) {
        return service.get(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    Doctor create(@RequestBody Doctor doctor) {
        return service.save(doctor);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    Doctor edit(@RequestBody Doctor doctor) {
        return service.save(doctor);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    Doctor delete(@PathVariable("id") String id) {
        return service.delete(id);
    }
}
