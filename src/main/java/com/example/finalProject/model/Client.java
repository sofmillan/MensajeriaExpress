package com.example.finalProject.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="client")
public class Client {
    @Id
    private Long id;
    private String name;
    private String lastName;
    private Long phoneNumber;
    private String email;
    private String address;

    private String city;

    public Client(){}
    public Client(Long id, String name, String lastName, Long phoneNumber, String email, String address, String city) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.city = city;
    }
}
