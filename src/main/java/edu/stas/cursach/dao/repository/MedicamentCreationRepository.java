package edu.stas.cursach.dao.repository;

import edu.stas.cursach.model.MedicamentCreation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MedicamentCreationRepository extends MongoRepository<MedicamentCreation, String> {
}
