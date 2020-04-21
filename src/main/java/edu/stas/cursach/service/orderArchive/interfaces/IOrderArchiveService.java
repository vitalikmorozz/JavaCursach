package edu.stas.cursach.service.orderArchive.interfaces;

import edu.stas.cursach.model.OrderArchive;

import java.util.List;

public interface IOrderArchiveService {
    OrderArchive save(OrderArchive orderArchive);
    OrderArchive edit(OrderArchive orderArchive);
    OrderArchive delete(String id);
    OrderArchive get(String id);
    List<OrderArchive> getAll();
}
