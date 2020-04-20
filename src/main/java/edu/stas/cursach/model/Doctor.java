package edu.stas.cursach.model;

import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

public class Doctor {
    @Id
    private String id;
    private LocalDateTime dateCreated;
    private LocalDateTime dateModified;

    private String name;
    private String position;

    public Doctor() {
    }

    public Doctor(String id, LocalDateTime dateCreated, LocalDateTime dateModified, String name, String position) {
        this.id = id;
        this.dateCreated = dateCreated;
        this.dateModified = dateModified;
        this.name = name;
        this.position = position;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id='" + id + '\'' +
                ", dateCreated=" + dateCreated +
                ", dateModified=" + dateModified +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}
