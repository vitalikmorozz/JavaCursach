package edu.stas.cursach.dao.repository;

import edu.stas.cursach.model.MedicamentUsage;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MedicamentUsageRepository extends MongoRepository<MedicamentUsage, String> {
    List<MedicamentUsage> findMedicamentUsagesByName(String name);
}
