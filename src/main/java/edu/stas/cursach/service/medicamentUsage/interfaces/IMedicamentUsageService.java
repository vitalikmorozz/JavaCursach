package edu.stas.cursach.service.medicamentUsage.interfaces;

import edu.stas.cursach.model.MedicamentUsage;

import java.util.List;

public interface IMedicamentUsageService {
    MedicamentUsage save(MedicamentUsage medicamentUsage);
    MedicamentUsage edit(MedicamentUsage medicamentUsage);
    MedicamentUsage delete(String id);
    MedicamentUsage get(String id);
    List<MedicamentUsage> getAll();
}
