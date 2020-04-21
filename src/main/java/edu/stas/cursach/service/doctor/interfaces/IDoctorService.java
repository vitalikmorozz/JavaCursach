package edu.stas.cursach.service.doctor.interfaces;

import edu.stas.cursach.model.Doctor;

import java.util.List;

public interface IDoctorService {
    Doctor save(Doctor doctor);
    Doctor edit(Doctor doctor);
    Doctor delete(String id);
    Doctor get(String id);
    List<Doctor> getAll();
}
