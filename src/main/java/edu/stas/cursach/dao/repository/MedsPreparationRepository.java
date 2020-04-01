package edu.stas.cursach.dao.repository;

import edu.stas.cursach.model.MedsPreparation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MedsPreparationRepository extends MongoRepository<MedsPreparation, String> {
}
