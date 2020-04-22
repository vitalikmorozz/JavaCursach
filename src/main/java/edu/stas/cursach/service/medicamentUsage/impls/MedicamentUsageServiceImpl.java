package edu.stas.cursach.service.medicamentUsage.impls;

import edu.stas.cursach.dao.repository.MedicamentUsageRepository;
import edu.stas.cursach.model.MedicamentUsage;
import edu.stas.cursach.service.medicamentUsage.interfaces.IMedicamentUsageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class MedicamentUsageServiceImpl implements IMedicamentUsageService {
    @Autowired
    MedicamentUsageRepository repository;

    @PostConstruct
    void init() {
        List<MedicamentUsage> medicamentUsages = new ArrayList<>(Arrays.asList(
                new MedicamentUsage("1", LocalDateTime.now(), LocalDateTime.now(), "External application", "Only for external application"),
                new MedicamentUsage("2", LocalDateTime.now(), LocalDateTime.now(), "Internal application", "Only for internal application")
        ));

        repository.saveAll(medicamentUsages);
    }
    
    @Override
    public MedicamentUsage save(MedicamentUsage medicamentUsage) {
        medicamentUsage.setDateCreated(LocalDateTime.now());
        medicamentUsage.setDateModified(LocalDateTime.now());
        return repository.save(medicamentUsage);
    }

    @Override
    public MedicamentUsage edit(MedicamentUsage medicamentUsage) {
        medicamentUsage.setDateModified(LocalDateTime.now());
        return repository.save(medicamentUsage);
    }

    @Override
    public MedicamentUsage delete(String id) {
        MedicamentUsage medicamentUsage = repository.findById(id).orElse(null);
        repository.deleteById(id);
        return medicamentUsage;
    }

    @Override
    public MedicamentUsage get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<MedicamentUsage> getAll() {
        return repository.findAll();
    }
}
