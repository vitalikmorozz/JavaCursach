package edu.stas.cursach.model;

import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

public class Client {
    @Id
    private String id;
    private LocalDateTime dateCreated;
    private LocalDateTime dateModified;

    private String name;
    private int age;
    private String address;
    private String phone;

    public Client() {
    }

    public Client(String id, LocalDateTime dateCreated, LocalDateTime dateModified, String name, int age, String address, String phone) {
        this.id = id;
        this.dateCreated = dateCreated;
        this.dateModified = dateModified;
        this.name = name;
        this.age = age;
        this.address = address;
        this.phone = phone;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id='" + id + '\'' +
                ", dateCreated=" + dateCreated +
                ", dateModified=" + dateModified +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
