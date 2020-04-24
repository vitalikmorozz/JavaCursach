package edu.stas.cursach.dao.repository;

import edu.stas.cursach.model.MedicamentType;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MedicamentTypeRepository extends MongoRepository<MedicamentType, String> {
    List<MedicamentType> findMedicamentTypesByName(String name);
}
