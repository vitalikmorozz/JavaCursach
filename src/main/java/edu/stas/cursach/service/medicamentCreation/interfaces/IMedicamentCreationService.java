package edu.stas.cursach.service.medicamentCreation.interfaces;

import edu.stas.cursach.model.MedicamentCreation;

import java.util.List;

public interface IMedicamentCreationService {
    MedicamentCreation save(MedicamentCreation medicamentCreation);
    MedicamentCreation edit(MedicamentCreation medicamentCreation);
    MedicamentCreation delete(String id);
    MedicamentCreation get(String id);
    List<MedicamentCreation> getAll();
}
