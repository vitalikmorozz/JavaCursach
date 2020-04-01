package edu.stas.cursach.dao.repository;

import edu.stas.cursach.model.MedsType;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MedsTypeRepository extends MongoRepository<MedsType, String> {
}
