package edu.stas.cursach.service.medicamentCreation.impls;

import edu.stas.cursach.dao.repository.MedicamentCreationRepository;
import edu.stas.cursach.model.MedicamentCreation;
import edu.stas.cursach.service.medicamentCreation.interfaces.IMedicamentCreationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class MedicamentCreationServiceImpl implements IMedicamentCreationService {
    @Autowired
    MedicamentCreationRepository repository;
    
    @PostConstruct
    void init() {
        List<MedicamentCreation> medicamentCreations = new ArrayList<>(Arrays.asList(
                new MedicamentCreation("1", LocalDateTime.now(), LocalDateTime.now(), "Hydrogen", "Water + Electricity", 1, "1")
        ));

        repository.saveAll(medicamentCreations);
    };
    
    @Override
    public MedicamentCreation save(MedicamentCreation medicamentCreation) {
        medicamentCreation.setDateCreated(LocalDateTime.now());
        medicamentCreation.setDateModified(LocalDateTime.now());
        return repository.save(medicamentCreation);
    }

    @Override
    public MedicamentCreation edit(MedicamentCreation medicamentCreation) {
        medicamentCreation.setDateModified(LocalDateTime.now());
        return repository.save(medicamentCreation);
    }

    @Override
    public MedicamentCreation delete(String id) {
        MedicamentCreation medicamentCreation = repository.findById(id).orElse(null);
        repository.deleteById(id);
        return medicamentCreation;
    }

    @Override
    public MedicamentCreation get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<MedicamentCreation> getAll() {
        return repository.findAll();
    }
}
