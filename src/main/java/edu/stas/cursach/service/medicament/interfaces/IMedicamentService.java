package edu.stas.cursach.service.medicament.interfaces;

import edu.stas.cursach.model.Medicament;

import java.util.List;

public interface IMedicamentService {
    Medicament save(Medicament medicament);
    Medicament edit(Medicament medicament);
    Medicament delete(String id);
    Medicament get(String id);
    List<Medicament> getAll();
}
