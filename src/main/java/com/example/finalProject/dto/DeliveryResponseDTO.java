package com.example.finalProject.dto;

public class DeliveryResponseDTO {

    private Long idClient;
    private String originCity;
    private String destinationCity;
    private String destinationAddress;
    private String receiverName;
    private Long receiverPhoneNumber;
    private Double packageDeclaredValue;
    private Double weight;
    private Double deliveryValue;
    private String status;
    private String guideNumber;

    public DeliveryResponseDTO(){}
    public DeliveryResponseDTO(Long idClient, String originCity, String destinationCity, String destinationAddress, String receiverName, Long receiverPhoneNumber,
                               Double packageDeclaredValue, Double weight, Double deliveryValue, String status, String guideNumber) {
        this.idClient = idClient;
        this.originCity = originCity;
        this.destinationCity = destinationCity;
        this.destinationAddress = destinationAddress;
        this.receiverName = receiverName;
        this.receiverPhoneNumber = receiverPhoneNumber;
        this.packageDeclaredValue = packageDeclaredValue;
        this.weight = weight;
        this.deliveryValue = deliveryValue;
        this.status = status;
        this.guideNumber = guideNumber;
    }

    public Long getIdClient() {
        return idClient;
    }

    public String getOriginCity() {
        return originCity;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public String getDestinationAddress() {
        return destinationAddress;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public Long getReceiverPhoneNumber() {
        return receiverPhoneNumber;
    }

    public Double getPackageDeclaredValue() {
        return packageDeclaredValue;
    }

    public Double getWeight() {
        return weight;
    }

    public Double getDeliveryValue() {
        return deliveryValue;
    }

    public String getStatus() {
        return status;
    }

    public String getGuideNumber() {
        return guideNumber;
    }
}
