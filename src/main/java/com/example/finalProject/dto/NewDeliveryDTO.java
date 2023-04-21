package com.example.finalProject.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="Delivery")
public class NewDeliveryDTO {
    private Long idClient;
    private String originCity;
    private String destinationCity;
    private String destinationAddress;
    private String receiverName;
    private Long receiverPhoneNumber;
    private Double packageDeclaredValue;
    private Double weight;


    public NewDeliveryDTO(){}


    public NewDeliveryDTO(Long idClient, String originCity, String destinationCity, String destinationAddress, String receiverName,
                          Long receiverPhoneNumber, Double packageDeclaredValue, Double weight) {
        this.idClient = idClient;
        this.originCity = originCity;
        this.destinationCity = destinationCity;
        this.receiverName = receiverName;
        this.receiverPhoneNumber = receiverPhoneNumber;
        this.packageDeclaredValue = packageDeclaredValue;
        this.weight = weight;
        this.destinationAddress = destinationAddress;
    }
    @ApiModelProperty(required = true)
    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }
    @ApiModelProperty(required = true)
    public String getOriginCity() {
        return originCity;
    }

    public void setOriginCity(String originCity) {
        this.originCity = originCity;
    }
    @ApiModelProperty(required = true)
    public String getDestinationCity() {
        return destinationCity;
    }

    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
    }
    @ApiModelProperty(required = true)
    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }
    @ApiModelProperty(required = true)
    public Long getReceiverPhoneNumber() {
        return receiverPhoneNumber;
    }

    public void setReceiverPhoneNumber(Long receiverPhoneNumber) {
        this.receiverPhoneNumber = receiverPhoneNumber;
    }
    @ApiModelProperty(required = true)
    public Double getPackageDeclaredValue() {
        return packageDeclaredValue;
    }

    public void setPackageDeclaredValue(Double packageDeclaredValue) {
        this.packageDeclaredValue = packageDeclaredValue;
    }
    @ApiModelProperty(required = true)
    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }
    @ApiModelProperty(required = true)
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
