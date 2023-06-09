package com.example.finalProject.model;

import com.sun.istack.NotNull;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="employee")
public class Employee {
    @Id
    @Column(name="idEmployee")
    private Long id;
    @Column(name="name")
    private String name;
    @Column(name="lastName")
    private String lastName;
    @Column(name="phoneNumber")
    private Long phoneNumber;
    @Column(name="email")
    private String email;
    @Column(name="address")
    private String address;
    @Column(name="city")
    private String city;
    @Column(name="seniority")
    private Integer seniority;
    @Column(name="bloodType")
    private String bloodType;
    @NotNull
    @Column(name="type")
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

    @ApiModelProperty(required = true)
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
