package edu.stas.cursach.dao.repository;

import edu.stas.cursach.model.Doctor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DoctorRepository extends MongoRepository<Doctor, String> {
}
