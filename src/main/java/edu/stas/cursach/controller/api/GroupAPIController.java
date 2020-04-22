package edu.stas.cursach.controller.api;

import edu.stas.cursach.model.Group;
import edu.stas.cursach.service.group.impls.GroupServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/group")
public class GroupAPIController {
    @Autowired
    GroupServiceImpl service;

    @RequestMapping(value = "/get/list", method = RequestMethod.GET)
    List<Group> getAll() {
        return service.getAll();
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    Group getById(@PathVariable("id") String id) {
        return service.get(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    Group create(@RequestBody Group group) {
        return service.save(group);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    Group edit(@RequestBody Group group) {
        return service.save(group);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    Group delete(@PathVariable("id") String id) {
        return service.delete(id);
    }
}
