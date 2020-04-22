package edu.stas.cursach.controller.api;

import edu.stas.cursach.model.Client;
import edu.stas.cursach.service.client.impls.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/client")
public class ClientAPIController {
    @Autowired
    ClientServiceImpl service;

    @RequestMapping(value = "/get/list", method = RequestMethod.GET)
    List<Client> getAll() {
        return service.getAll();
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    Client getById(@PathVariable("id") String id) {
        return service.get(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    Client create(@RequestBody Client client) {
        return service.save(client);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    Client edit(@RequestBody Client client) {
        return service.save(client);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    Client delete(@PathVariable("id") String id) {
        return service.delete(id);
    }
}
