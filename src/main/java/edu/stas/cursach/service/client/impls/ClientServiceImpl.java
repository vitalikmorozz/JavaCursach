package edu.stas.cursach.service.client.impls;

import edu.stas.cursach.dao.repository.ClientRepository;
import edu.stas.cursach.model.Client;
import edu.stas.cursach.service.client.interfaces.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClientServiceImpl implements IClientService {
    @Autowired
    ClientRepository repository;

    @PostConstruct
    void init(){}

    @Override
    public Client save(Client client) {
        client.setDateCreated(LocalDateTime.now());
        client.setDateModified(LocalDateTime.now());
        return repository.save(client);
    }

    @Override
    public Client edit(Client client) {
        client.setDateModified(LocalDateTime.now());
        return repository.save(client);
    }

    @Override
    public Client delete(String id) {
        Client client = repository.findById(id).orElse(null);
        repository.deleteById(id);
        return client;
    }

    @Override
    public Client get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Client> getAll() {
        return repository.findAll();
    }
}
