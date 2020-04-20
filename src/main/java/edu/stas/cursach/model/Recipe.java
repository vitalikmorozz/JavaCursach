package edu.stas.cursach.model;

import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

public class Recipe {
    @Id
    private String id;
    private LocalDateTime dateCreated;
    private LocalDateTime dateModified;

    private String doctorId;
    private String clientId;
    private String diagnosis;
    private String medicamentId;
    private int medicamentAmount;

    public Recipe() {
    }

    public Recipe(String id, LocalDateTime dateCreated, LocalDateTime dateModified, String doctorId, String clientId, String diagnosis, String medicamentId, int medicamentAmount) {
        this.id = id;
        this.dateCreated = dateCreated;
        this.dateModified = dateModified;
        this.doctorId = doctorId;
        this.clientId = clientId;
        this.diagnosis = diagnosis;
        this.medicamentId = medicamentId;
        this.medicamentAmount = medicamentAmount;
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

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getMedicamentId() {
        return medicamentId;
    }

    public void setMedicamentId(String medicamentId) {
        this.medicamentId = medicamentId;
    }

    public int getMedicamentAmount() {
        return medicamentAmount;
    }

    public void setMedicamentAmount(int medicamentAmount) {
        this.medicamentAmount = medicamentAmount;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id='" + id + '\'' +
                ", dateCreated=" + dateCreated +
                ", dateModified=" + dateModified +
                ", doctorId='" + doctorId + '\'' +
                ", clientId='" + clientId + '\'' +
                ", diagnosis='" + diagnosis + '\'' +
                ", medicamentId='" + medicamentId + '\'' +
                ", medicamentAmount=" + medicamentAmount +
                '}';
    }
}
