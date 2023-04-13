package com.example.finalProject.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
    @Id
    private Long id;
    private String name;
    private String lastName;
    private Long phoneNumber;
    private String email;
    private String address;

    private String city;

    private Integer seniority;

    private String bloodType;

    private String type;

    public Employee(){}
    public Employee(Long id, String name, String lastName, Long phoneNumber, String email,
                    String address, String city, Integer seniority, String bloodType, String type) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.city = city;
        this.seniority = seniority;
        this.bloodType = bloodType;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public Integer getSeniority() {
        return seniority;
    }

    public String getBloodType() {
        return bloodType;
    }

    public String getType() {
        return type;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setSeniority(Integer seniority) {
        this.seniority = seniority;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public void setType(String type) {
        this.type = type;
    }
}
