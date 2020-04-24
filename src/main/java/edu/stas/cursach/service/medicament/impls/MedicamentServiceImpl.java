package edu.stas.cursach.service.medicament.impls;

import edu.stas.cursach.dao.repository.MedicamentRepository;
import edu.stas.cursach.model.Medicament;
import edu.stas.cursach.service.medicament.interfaces.IMedicamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class MedicamentServiceImpl implements IMedicamentService {
    @Autowired
    MedicamentRepository repository;

    @PostConstruct
    void init(){
        List<Medicament> medicaments = new ArrayList<>(Arrays.asList(
                new Medicament("1", LocalDateTime.now(), LocalDateTime.now(), "Noradrenaline", "Some text", 25, 5, 1, LocalDate.now().minusDays(5), "1", "2", "1")
        ));

        repository.saveAll(medicaments);
    };

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

    public List<Medicament> findByName(String name) {
        return repository.findMedicamentsByName(name);
    }
}
