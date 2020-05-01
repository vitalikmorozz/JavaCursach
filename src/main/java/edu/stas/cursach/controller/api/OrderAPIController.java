package edu.stas.cursach.controller.api;

import edu.stas.cursach.model.Order;
import edu.stas.cursach.service.order.impls.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class OrderAPIController {
    @Autowired
    OrderServiceImpl service;

    @RequestMapping(value = "/get/list", method = RequestMethod.GET)
    List<Order> getAll() {
        return service.getAll();
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    Order getById(@PathVariable("id") String id) {
        return service.get(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    Order create(@RequestBody Order order) {
        return service.save(order);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    Order edit(@RequestBody Order order) {
        return service.save(order);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    Order delete(@PathVariable("id") String id) {
        return service.delete(id);
    }
}
