package com.example.finalProject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name="package")
public class Package {
    @Id
    @Column(name="identifier")
    private UUID identifier;
    @Column(name="packageType")
    private String type;
    @Column(name="weight")
    private Double weight;
    @Column(name="declaredValue")
    private Double declaredValue;

    public Package(){}
    public Package(String type, Double weight, Double declaredValue) {
        this.identifier = UUID.randomUUID();
        this.type = type;
        this.weight = weight;
        this.declaredValue = declaredValue;
    }

    public UUID getId() {
        return identifier;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getDeclaredValue() {
        return declaredValue;
    }

    public void setDeclaredValue(Double declaredValue) {
        this.declaredValue = declaredValue;
    }

    @Override
    public String toString() {
        return "Package{" +
                "identifier=" + identifier +
                ", type='" + type + '\'' +
                ", weight=" + weight +
                ", declaredValue=" + declaredValue +
                '}';
    }
}
