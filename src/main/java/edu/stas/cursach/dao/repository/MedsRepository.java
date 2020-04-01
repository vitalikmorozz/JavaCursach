package edu.stas.cursach.dao.repository;

import edu.stas.cursach.model.Meds;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MedsRepository extends MongoRepository<Meds, String> {
}
