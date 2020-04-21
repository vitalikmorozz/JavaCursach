package edu.stas.cursach.service.doctor.impls;

import edu.stas.cursach.dao.repository.DoctorRepository;
import edu.stas.cursach.model.Doctor;
import edu.stas.cursach.service.doctor.interfaces.IDoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class DoctorServiceImpl implements IDoctorService {
    @Autowired
    DoctorRepository repository;

    @PostConstruct
    void init(){};

    @Override
    public Doctor save(Doctor doctor) {
        doctor.setDateCreated(LocalDateTime.now());
        doctor.setDateModified(LocalDateTime.now());
        return repository.save(doctor);
    }

    @Override
    public Doctor edit(Doctor doctor) {
        doctor.setDateModified(LocalDateTime.now());
        return repository.save(doctor);
    }

    @Override
    public Doctor delete(String id) {
        Doctor doctor = repository.findById(id).orElse(null);
        repository.deleteById(id);
        return doctor;
    }

    @Override
    public Doctor get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Doctor> getAll() {
        return repository.findAll();
    }
}
