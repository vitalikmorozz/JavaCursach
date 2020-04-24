package edu.stas.cursach.dao.repository;

import edu.stas.cursach.model.MedicamentCreation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MedicamentCreationRepository extends MongoRepository<MedicamentCreation, String> {
    List<MedicamentCreation> findMedicamentCreationsByName(String name);
}
