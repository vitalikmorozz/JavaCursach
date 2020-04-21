package edu.stas.cursach.service.order.interfaces;

import edu.stas.cursach.model.Order;

import java.util.List;

public interface IOrderService {
    Order save(Order order);
    Order edit(Order order);
    Order delete(String id);
    Order get(String id);
    List<Order> getAll();
}
