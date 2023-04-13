package com.example.finalProject.model;

public class DeliveryDTO {
    private Long idClient;
    private String originCity;
    private String destinationCity;
    private String receiverName;
    private Long receiverPhoneNumber;
    private Double packageDeclaredValue;
    private Double weight;
    private String destinationAddress;

    public DeliveryDTO(){}


    public DeliveryDTO(Long idClient, String originCity, String destinationCity, String receiverName,
                       Long receiverPhoneNumber, Double packageDeclaredValue, Double weight, String destinationAddress) {
        this.idClient = idClient;
        this.originCity = originCity;
        this.destinationCity = destinationCity;
        this.receiverName = receiverName;
        this.receiverPhoneNumber = receiverPhoneNumber;
        this.packageDeclaredValue = packageDeclaredValue;
        this.weight = weight;
        this.destinationAddress = destinationAddress;
    }

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    public String getOriginCity() {
        return originCity;
    }

    public void setOriginCity(String originCity) {
        this.originCity = originCity;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
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

    public Double getPackageDeclaredValue() {
        return packageDeclaredValue;
    }

    public void setPackageDeclaredValue(Double packageDeclaredValue) {
        this.packageDeclaredValue = packageDeclaredValue;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getDestinationAddress() {
        return destinationAddress;
    }

    public void setDestinationAddress(String destinationAddress) {
        this.destinationAddress = destinationAddress;
    }

    @Override
    public String toString() {
        return "DeliveryDTO{" +
                "idClient=" + idClient +
                ", originCity='" + originCity + '\'' +
                ", destinationCity='" + destinationCity + '\'' +
                ", receiverName='" + receiverName + '\'' +
                ", receiverPhoneNumber=" + receiverPhoneNumber +
                ", packageDeclaredValue=" + packageDeclaredValue +
                ", weight=" + weight +
                ", destinationAddress='" + destinationAddress + '\'' +
                '}';
    }
}
