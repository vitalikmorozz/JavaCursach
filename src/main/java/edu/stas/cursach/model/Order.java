package edu.stas.cursach.model;

import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

public class Order {
    @Id
    private String id;
    private LocalDateTime dateCreated;
    private LocalDateTime dateModified;

    private String recipeId;
    private Boolean isAllIngredientsAvailable;
    private Boolean isReady;
    private Boolean isReceived;

    public Order() {
    }

    public Order(String id, LocalDateTime dateCreated, LocalDateTime dateModified, String recipeId, Boolean isAllIngredientsAvailable, Boolean isReady, Boolean isReceived) {
        this.id = id;
        this.dateCreated = dateCreated;
        this.dateModified = dateModified;
        this.recipeId = recipeId;
        this.isAllIngredientsAvailable = isAllIngredientsAvailable;
        this.isReady = isReady;
        this.isReceived = isReceived;
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

    public String getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(String recipeId) {
        this.recipeId = recipeId;
    }

    public Boolean getAllIngredientsAvailable() {
        return isAllIngredientsAvailable;
    }

    public void setAllIngredientsAvailable(Boolean allIngredientsAvailable) {
        isAllIngredientsAvailable = allIngredientsAvailable;
    }

    public Boolean getReady() {
        return isReady;
    }

    public void setReady(Boolean ready) {
        isReady = ready;
    }

    public Boolean getReceived() {
        return isReceived;
    }

    public void setReceived(Boolean received) {
        isReceived = received;
    }


    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", dateCreated=" + dateCreated +
                ", dateModified=" + dateModified +
                ", recipeId='" + recipeId + '\'' +
                ", isAllIngredientsAvailable=" + isAllIngredientsAvailable +
                ", isReady=" + isReady +
                ", isReceived=" + isReceived +
                '}';
    }
}
