package edu.stas.cursach.dao.repository;

import edu.stas.cursach.model.Diagnosis;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DiagnosisRepository extends MongoRepository<Diagnosis, String> {
}
