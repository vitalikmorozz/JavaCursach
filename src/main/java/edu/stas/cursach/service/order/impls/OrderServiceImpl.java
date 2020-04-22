package edu.stas.cursach.service.order.impls;

import edu.stas.cursach.dao.repository.OrderRepository;
import edu.stas.cursach.model.Order;
import edu.stas.cursach.service.order.interfaces.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService {
    @Autowired
    OrderRepository repository;
    
    @PostConstruct
    void init() {
        List<Order> orders = new ArrayList<>(Arrays.asList(
                new Order("1", LocalDateTime.now(), LocalDateTime.now(), "1", true, true, true),
                new Order("2", LocalDateTime.now(), LocalDateTime.now(), "2", false, false, false),
                new Order("3", LocalDateTime.now(), LocalDateTime.now(), "3", true, true, true)
        ));

        repository.saveAll(orders);
    };
    
    @Override
    public Order save(Order order) {
        order.setDateCreated(LocalDateTime.now());
        order.setDateModified(LocalDateTime.now());
        return repository.save(order);
    }

    @Override
    public Order edit(Order order) {
        order.setDateModified(LocalDateTime.now());
        return repository.save(order);
    }

    @Override
    public Order delete(String id) {
        Order order = repository.findById(id).orElse(null);
        repository.deleteById(id);
        return order;
    }

    @Override
    public Order get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Order> getAll() {
        return repository.findAll();
    }
}
