package edu.stas.cursach.service.orderArchive.impls;

import edu.stas.cursach.dao.repository.OrderArchiveRepository;
import edu.stas.cursach.model.OrderArchive;
import edu.stas.cursach.service.orderArchive.interfaces.IOrderArchiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderArchiveServiceImpl implements IOrderArchiveService {
    @Autowired
    OrderArchiveRepository repository;
    
    @PostConstruct
    void init() {};
    
    @Override
    public OrderArchive save(OrderArchive orderArchive) {
        orderArchive.setDateCreated(LocalDateTime.now());
        orderArchive.setDateModified(LocalDateTime.now());
        return repository.save(orderArchive);
    }

    @Override
    public OrderArchive edit(OrderArchive orderArchive) {
        orderArchive.setDateModified(LocalDateTime.now());
        return repository.save(orderArchive);
    }

    @Override
    public OrderArchive delete(String id) {
        OrderArchive orderArchive = repository.findById(id).orElse(null);
        repository.deleteById(id);
        return orderArchive;
    }

    @Override
    public OrderArchive get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<OrderArchive> getAll() {
        return repository.findAll();
    }
}
