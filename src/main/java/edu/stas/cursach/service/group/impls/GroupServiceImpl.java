package edu.stas.cursach.service.group.impls;

import edu.stas.cursach.dao.repository.GroupRepository;
import edu.stas.cursach.model.Group;
import edu.stas.cursach.service.group.interfaces.IGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class GroupServiceImpl implements IGroupService {
    @Autowired
    GroupRepository repository;

    @PostConstruct
    void init(){
        List<Group> groups = new ArrayList<>(Arrays.asList(
                new Group("1", "243", "description",
                        LocalDateTime.now(), LocalDateTime.now()),
                new Group("2", "243sk", "description",
                        LocalDateTime.now(), LocalDateTime.now()),
                new Group("3", "111", "Hello world",
                        LocalDateTime.now(), LocalDateTime.now())
        ));
        repository.saveAll(groups);
    }

    @Override
    public Group save(Group group) {
        group.setDateCreated(LocalDateTime.now());
        group.setDateModified(LocalDateTime.now());
        return repository.save(group);
    }

    @Override
    public Group get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Group> getAll() {
        return repository.findAll();
    }

    @Override
    public Group edit(Group group) {
        group.setDateModified(LocalDateTime.now());
        return repository.save(group);
    }

    @Override
    public Group delete(String id) {
        Group group = repository.findById(id).orElse(null);
        repository.deleteById(id);
        return group;
    }
}
