package edu.stas.cursach.service.group.impls;

import edu.stas.cursach.dao.repository.GroupRepository;
import edu.stas.cursach.model.Group;
import edu.stas.cursach.service.group.interfaces.IGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class GroupServiceImpl implements IGroupService {
    @Autowired
    GroupRepository repository;

    @PostConstruct
    void init(){

    }

    @Override
    public Group save(Group group) {
        return null;
    }

    @Override
    public Group get(String id) {
        return null;
    }

    @Override
    public List<Group> getAll() {
        return repository.findAll();
    }

    @Override
    public Group edit(Group group) {
        return null;
    }

    @Override
    public Group delete(String id) {
        repository.deleteById(id);
        return repository.findById(id).orElse(null);
    }
}
