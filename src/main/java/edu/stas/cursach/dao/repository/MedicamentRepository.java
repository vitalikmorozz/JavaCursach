package edu.stas.cursach.dao.repository;

import edu.stas.cursach.model.Medicament;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MedicamentRepository extends MongoRepository<Medicament, String> {
}
