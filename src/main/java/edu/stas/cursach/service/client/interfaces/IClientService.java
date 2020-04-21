package edu.stas.cursach.service.client.interfaces;

import edu.stas.cursach.model.Client;

import java.util.List;

public interface IClientService {
    Client save(Client client);
    Client edit(Client client);
    Client delete(String id);
    Client get(String id);
    List<Client> getAll();
}
