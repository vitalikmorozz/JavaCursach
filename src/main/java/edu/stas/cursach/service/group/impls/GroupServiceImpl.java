package edu.stas.cursach.service.group.impls;

import edu.stas.cursach.dao.group.impls.GroupDaoImplFake;
import edu.stas.cursach.dao.group.interfaces.IGroupDao;
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
    GroupDaoImplFake dao;

    @PostConstruct
    void init(){
        List<Group> list = dao.getAll();

//        repository.saveAll(list);
    }

    @Override
    public Group save(Group group) {
        return null;
    }

    @Override
    public Group get(String id) {
        return dao.getAll().stream().filter(item -> item.getId().equals(id))
                .findFirst().orElse(null);
    }

    @Override
    public List<Group> getAll() {
        return dao.getAll();
    }

    @Override
    public Group edit(Group group) {
        return null;
    }

    @Override
    public Group delete(String id) {
        Group group = this.get(id);
        dao.getAll().remove(group);
        return group;
    }
}
