package edu.stas.cursach.controller.api;

import edu.stas.cursach.model.OrderArchive;
import edu.stas.cursach.service.orderArchive.impls.OrderArchiveServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orderArchive")
public class OrderArchiveAPIController {
    @Autowired
    OrderArchiveServiceImpl service;

    @RequestMapping(value = "/get/list", method = RequestMethod.GET)
    List<OrderArchive> getAll() {
        return service.getAll();
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    OrderArchive getById(@PathVariable("id") String id) {
        return service.get(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    OrderArchive create(@RequestBody OrderArchive orderArchive) {
        return service.save(orderArchive);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    OrderArchive edit(@RequestBody OrderArchive orderArchive) {
        return service.save(orderArchive);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    OrderArchive delete(@PathVariable("id") String id) {
        return service.delete(id);
    }
}
