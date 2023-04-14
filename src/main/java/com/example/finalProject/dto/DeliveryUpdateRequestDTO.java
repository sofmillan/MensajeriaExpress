package com.example.finalProject.dto;

public class DeliveryUpdateRequestDTO {
    private String guideNumber;
    private String deliveryStatus;
    private Long idEmployee;

    public DeliveryUpdateRequestDTO(){}
    public DeliveryUpdateRequestDTO(String guideNumber, String deliveryStatus, Long idEmployee) {
        this.guideNumber = guideNumber;
        this.deliveryStatus = deliveryStatus;
        this.idEmployee = idEmployee;
    }

    public String getGuideNumber() {
        return guideNumber;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public Long getIdEmployee() {
        return idEmployee;
    }
}
