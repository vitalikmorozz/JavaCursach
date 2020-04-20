package edu.stas.cursach.model;

import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

public class Medicament {
    @Id
    private String id;
    private LocalDateTime dateCreated;
    private LocalDateTime dateModified;

    private String name;
    private String description;
    private int price;
    private int currentAmount;
    private int minimalAmount;
    private LocalDateTime expirationDate;
    private String medicamentTypeId;
    private String medicamentUsageId;
    private String medicamentCreationId;

    public Medicament() {
    }

    public Medicament(String id, LocalDateTime dateCreated, LocalDateTime dateModified, String name, String description, int price, int currentAmount, int minimalAmount, LocalDateTime expirationDate, String medicamentTypeId, String medicamentUsageId, String medicamentCreationId) {
        this.id = id;
        this.dateCreated = dateCreated;
        this.dateModified = dateModified;
        this.name = name;
        this.description = description;
        this.price = price;
        this.currentAmount = currentAmount;
        this.minimalAmount = minimalAmount;
        this.expirationDate = expirationDate;
        this.medicamentTypeId = medicamentTypeId;
        this.medicamentUsageId = medicamentUsageId;
        this.medicamentCreationId = medicamentCreationId;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCurrentAmount() {
        return currentAmount;
    }

    public void setCurrentAmount(int currentAmount) {
        this.currentAmount = currentAmount;
    }

    public int getMinimalAmount() {
        return minimalAmount;
    }

    public void setMinimalAmount(int minimalAmount) {
        this.minimalAmount = minimalAmount;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDateTime expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getMedicamentTypeId() {
        return medicamentTypeId;
    }

    public void setMedicamentTypeId(String medicamentTypeId) {
        this.medicamentTypeId = medicamentTypeId;
    }

    public String getMedicamentUsageId() {
        return medicamentUsageId;
    }

    public void setMedicamentUsageId(String medicamentUsageId) {
        this.medicamentUsageId = medicamentUsageId;
    }

    public String getMedicamentCreationId() {
        return medicamentCreationId;
    }

    public void setMedicamentCreationId(String medicamentCreationId) {
        this.medicamentCreationId = medicamentCreationId;
    }

    @Override
    public String toString() {
        return "Medicament{" +
                "id='" + id + '\'' +
                ", dateCreated=" + dateCreated +
                ", dateModified=" + dateModified +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", currentAmount=" + currentAmount +
                ", minimalAmount=" + minimalAmount +
                ", expirationDate=" + expirationDate +
                ", medicamentTypeId='" + medicamentTypeId + '\'' +
                ", medicamentUsageId='" + medicamentUsageId + '\'' +
                ", medicamentCreationId='" + medicamentCreationId + '\'' +
                '}';
    }
}
