package edu.stas.cursach.controller.web;

import edu.stas.cursach.model.Doctor;
import edu.stas.cursach.service.doctor.impls.DoctorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/web/doctor")
public class DoctorWEBController {
    @Autowired
    DoctorServiceImpl service;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    String getAll(Model model) {
        model.addAttribute("doctors", service.getAll());
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
