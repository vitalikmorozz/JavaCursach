package edu.stas.cursach.model;

import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

public class MedicamentCreation {
    @Id
    private String id;
    private LocalDateTime dateCreated;
    private LocalDateTime dateModified;

    private String name;
    private String creationDescription;
    private int ingredientAmount;
    private String ingredientId;

    public MedicamentCreation() {
    }

    public MedicamentCreation(String id, LocalDateTime dateCreated, LocalDateTime dateModified, String name, String creationDescription, int ingredientAmount, String ingredientId) {
        this.id = id;
        this.dateCreated = dateCreated;
        this.dateModified = dateModified;
        this.name = name;
        this.creationDescription = creationDescription;
        this.ingredientAmount = ingredientAmount;
        this.ingredientId = ingredientId;
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

    public String getCreationDescription() {
        return creationDescription;
    }

    public void setCreationDescription(String creationDescription) {
        this.creationDescription = creationDescription;
    }

    public int getIngredientAmount() {
        return ingredientAmount;
    }

    public void setIngredientAmount(int ingredientAmount) {
        this.ingredientAmount = ingredientAmount;
    }

    public String getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(String ingredientId) {
        this.ingredientId = ingredientId;
    }

    @Override
    public String toString() {
        return "MedicamentCreation{" +
                "id='" + id + '\'' +
                ", dateCreated=" + dateCreated +
                ", dateModified=" + dateModified +
                ", name='" + name + '\'' +
                ", creationDescription='" + creationDescription + '\'' +
                ", ingredientAmount=" + ingredientAmount +
                ", ingredientId='" + ingredientId + '\'' +
                '}';
    }
}
