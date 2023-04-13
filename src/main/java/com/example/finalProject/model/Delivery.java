package com.example.finalProject.model;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name="delivery")
public class Delivery {
    @Id
    private UUID guideNumber;
    @ManyToOne
    @JoinColumn(name="id")
    private Client client;
    @OneToOne
    @JoinColumn(name="identifier")
    private Package package1;
    private String destinationCity;
    private String originCity;
    private String destinationAddress;
    private String receiverName;
    private Long receiverPhoneNumber;
    private String deliveryStatus;
    private Double deliveryValue;

    public Delivery(){}

    public Delivery(Client client, Package package1, String destinationCity, String originCity, String destinationAddress,
                    String receiverName, Long receiverPhoneNumber, String deliveryStatus, Double deliveryValue) {
        this.guideNumber = UUID.randomUUID();
        this.client = client;
        this.package1 = package1;
        this.destinationCity = destinationCity;
        this.originCity = originCity;
        this.destinationAddress = destinationAddress;
        this.receiverName = receiverName;
        this.receiverPhoneNumber = receiverPhoneNumber;
        this.deliveryStatus = deliveryStatus;
        this.deliveryValue = deliveryValue;
    }

    public UUID getGuideNumber() {
        return guideNumber;
    }

    public void setGuideNumber(UUID guideNumber) {
        this.guideNumber = guideNumber;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Package getPackage1() {
        return package1;
    }

    public void setPackage1(Package package1) {
        this.package1 = package1;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
    }

    public String getOriginCity() {
        return originCity;
    }

    public void setOriginCity(String originCity) {
        this.originCity = originCity;
    }

    public String getDestinationAddress() {
        return destinationAddress;
    }

    public void setDestinationAddress(String destinationAddress) {
        this.destinationAddress = destinationAddress;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public Long getReceiverPhoneNumber() {
        return receiverPhoneNumber;
    }

    public void setReceiverPhoneNumber(Long receiverPhoneNumber) {
        this.receiverPhoneNumber = receiverPhoneNumber;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public Double getDeliveryValue() {
        return deliveryValue;
    }

    public void setDeliveryValue(Double deliveryValue) {
        this.deliveryValue = deliveryValue;
    }

    @Override
    public String toString() {
        return "Delivery{" +
                "guideNumber=" + guideNumber +
                ", client=" + client +
                ", package1=" + package1 +
                ", destinationCity='" + destinationCity + '\'' +
                ", originCity='" + originCity + '\'' +
                ", destinationAddress='" + destinationAddress + '\'' +
                ", receiverName='" + receiverName + '\'' +
                ", receiverPhoneNumber=" + receiverPhoneNumber +
                ", deliveryStatus='" + deliveryStatus + '\'' +
                ", deliveryValue=" + deliveryValue +
                '}';
    }
}
