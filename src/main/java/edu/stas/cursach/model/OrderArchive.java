package edu.stas.cursach.model;

import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class OrderArchive {
    @Id
    private String id;
    private LocalDateTime dateCreated;
    private LocalDateTime dateModified;

    private String orderId;
    private LocalDate receiveDate;

    public OrderArchive() {
    }

    public OrderArchive(String id, LocalDateTime dateCreated, LocalDateTime dateModified, String orderId, LocalDate receiveDate) {
        this.id = id;
        this.dateCreated = dateCreated;
        this.dateModified = dateModified;
        this.orderId = orderId;
        this.receiveDate = receiveDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public LocalDateTime getDateModified() {
        return dateModified;
    }

    public void setDateModified(LocalDateTime dateModified) {
        this.dateModified = dateModified;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public LocalDate getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(LocalDate receiveDate) {
        this.receiveDate = receiveDate;
    }

    @Override
    public String toString() {
        return "OrderArchive{" +
                "id='" + id + '\'' +
                ", dateCreated=" + dateCreated +
                ", dateModified=" + dateModified +
                ", orderId='" + orderId + '\'' +
                ", receiveDate=" + receiveDate +
                '}';
    }
}
