package com.example.finalProject.dto;

import io.swagger.v3.oas.annotations.Hidden;
import springfox.documentation.annotations.ApiIgnore;

@Hidden
@ApiIgnore
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
