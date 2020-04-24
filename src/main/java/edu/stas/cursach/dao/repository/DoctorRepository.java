package edu.stas.cursach.dao.repository;

import edu.stas.cursach.model.Doctor;
import org.springframework.data.mongodb.repository.MongoRepository;

import javax.print.Doc;
import java.util.List;

public interface DoctorRepository extends MongoRepository<Doctor, String> {
    List<Doctor> findDoctorsByName(String name);
}
