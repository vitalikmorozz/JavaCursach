package edu.stas.cursach.service.medicamentType.interfaces;

import edu.stas.cursach.model.MedicamentType;

import java.util.List;

public interface IMedicamentTypeService {
    MedicamentType save(MedicamentType medicamentType);
    MedicamentType edit(MedicamentType medicamentType);
    MedicamentType delete(String id);
    MedicamentType get(String id);
    List<MedicamentType> getAll();
}
