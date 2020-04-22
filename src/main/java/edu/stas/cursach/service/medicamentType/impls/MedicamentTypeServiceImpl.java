package edu.stas.cursach.service.medicamentType.impls;

import edu.stas.cursach.dao.repository.MedicamentTypeRepository;
import edu.stas.cursach.model.MedicamentType;
import edu.stas.cursach.service.medicamentType.interfaces.IMedicamentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class MedicamentTypeServiceImpl implements IMedicamentTypeService {
    @Autowired
    MedicamentTypeRepository repository;
    
    @PostConstruct
    void init() {
        List<MedicamentType> medicamentTypes = new ArrayList<>(Arrays.asList(
                new MedicamentType("1", LocalDateTime.now(), LocalDateTime.now(), "Tablet", ""),
                new MedicamentType("2", LocalDateTime.now(), LocalDateTime.now(), "Capsule", ""),
                new MedicamentType("3", LocalDateTime.now(), LocalDateTime.now(), "Ointment", "")
        ));

        repository.saveAll(medicamentTypes);
    };
    
    @Override
    public MedicamentType save(MedicamentType medicamentType) {
        medicamentType.setDateCreated(LocalDateTime.now());
        medicamentType.setDateModified(LocalDateTime.now());
        return repository.save(medicamentType);
    }

    @Override
    public MedicamentType edit(MedicamentType medicamentType) {
        medicamentType.setDateModified(LocalDateTime.now());
        return repository.save(medicamentType);
    }

    @Override
    public MedicamentType delete(String id) {
        MedicamentType medicamentType = repository.findById(id).orElse(null);
        repository.deleteById(id);
        return medicamentType;
    }

    @Override
    public MedicamentType get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<MedicamentType> getAll() {
        return repository.findAll();
    }
}
