package edu.stas.cursach.service.medicament.impls;

import edu.stas.cursach.dao.repository.MedicamentRepository;
import edu.stas.cursach.model.Medicament;
import edu.stas.cursach.service.medicament.interfaces.IMedicamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class MedicamentServiceImpl implements IMedicamentService {
    @Autowired
    MedicamentRepository repository;

    @PostConstruct
    void init(){};

    @Override
    public Medicament save(Medicament medicament) {
        medicament.setDateCreated(LocalDateTime.now());
        medicament.setDateModified(LocalDateTime.now());
        return repository.save(medicament);
    }

    @Override
    public Medicament edit(Medicament medicament) {
        medicament.setDateModified(LocalDateTime.now());
        return repository.save(medicament);
    }

    @Override
    public Medicament delete(String id) {
        Medicament medicament = repository.findById(id).orElse(null);
        repository.deleteById(id);
        return medicament;
    }

    @Override
    public Medicament get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Medicament> getAll() {
        return repository.findAll();
    }
}
