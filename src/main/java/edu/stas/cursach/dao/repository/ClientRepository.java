package edu.stas.cursach.dao.repository;

import edu.stas.cursach.model.Client;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;
import org.springframework.data.mongodb.repository.MongoRepository;
import sun.misc.Regexp;

import java.util.List;

public interface ClientRepository extends MongoRepository<Client, String> {
    List<Client> findClientsByName(String name);
//    List<Client> findClientsByNameNear(String name);
//    List<Client> findClientsByNameNear(String name);
//    List<Client> findClientsByNameNear(String name);

}
