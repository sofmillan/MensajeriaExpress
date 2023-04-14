package com.example.finalProject.dto;

public class DeliveryConfirmationDTO {
    private String guideNumber;
    private String deliveryStatus;

    public DeliveryConfirmationDTO(){}
    public DeliveryConfirmationDTO(String guideNumber, String deliveryStatus) {
        this.guideNumber = guideNumber;
        this.deliveryStatus = deliveryStatus;
    }

    public String getGuideNumber() {
        return guideNumber;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }
}
