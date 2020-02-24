package edu.stas.cursach.dao.repository;

import edu.stas.cursach.model.Group;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GroupRepository extends MongoRepository<Group, String> {
}
