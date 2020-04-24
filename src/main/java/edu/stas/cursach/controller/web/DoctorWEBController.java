package edu.stas.cursach.controller.web;

import edu.stas.cursach.model.Doctor;
import edu.stas.cursach.service.doctor.impls.DoctorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/web/doctor")
public class DoctorWEBController {
    @Autowired
    DoctorServiceImpl service;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    String getAll(@RequestParam(required = false) String filter, @RequestParam(required = false) boolean sort, Model model) {
        List<Doctor> list;

        if(filter != null && !filter.isEmpty()) {
            list = service.findByName(filter);
        } else {
            list = service.getAll();
            filter = "";
        }

        model.addAttribute("doctors", list);
        model.addAttribute("filter", filter);
        model.addAttribute("sort", sort);
        return "listPages/doctorList";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    String delete(@PathVariable("id") String id) {
        service.delete(id);
        return "redirect:/web/doctor/list";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    String create(Model model) {
        model.addAttribute("doctor", new Doctor());
        return "addPages/doctorAdd";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    String create(@ModelAttribute("doctor") Doctor doctor) {
        service.save(doctor);
        return "redirect:/web/doctor/list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    String edit(Model model, @PathVariable("id") String id) {
        Doctor doctor = service.get(id);
        model.addAttribute("doctor", doctor);
        return "addPages/doctorAdd";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    String edit(@PathVariable("id") String id, @ModelAttribute("doctor") Doctor doctor) {
        doctor.setId(id);
        service.save(doctor);
        return "redirect:/web/doctor/list";
    }
}
