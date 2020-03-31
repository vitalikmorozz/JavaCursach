package edu.stas.cursach.model;

import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

public class Diagnosis {
    @Id
    private String id;
    private String diagnosis;
    private String description;
    private LocalDateTime dateCreated;
    private LocalDateTime dateModified;

    private String clientId;

    public Diagnosis(String id, String diagnosis, String description, LocalDateTime dateCreated, LocalDateTime dateModified, String clientId) {
        this.id = id;
        this.diagnosis = diagnosis;
        this.description = description;
        this.dateCreated = dateCreated;
        this.dateModified = dateModified;
        this.clientId = clientId;
    }

    public Diagnosis() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    @Override
    public String toString() {
        return "Diagnosis{" +
                "id='" + id + '\'' +
                ", diagnosis='" + diagnosis + '\'' +
                ", description='" + description + '\'' +
                ", dateCreated=" + dateCreated +
                ", dateModified=" + dateModified +
                ", clientId='" + clientId + '\'' +
                '}';
    }
}
