package edu.stas.cursach.dao.repository;

import edu.stas.cursach.model.MedsUsage;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MedsUsageRepository extends MongoRepository<MedsUsage, String> {
}
