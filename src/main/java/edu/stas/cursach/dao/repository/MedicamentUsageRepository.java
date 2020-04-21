package edu.stas.cursach.dao.repository;

import edu.stas.cursach.model.MedicamentUsage;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MedicamentUsageRepository extends MongoRepository<MedicamentUsage, String> {
}
