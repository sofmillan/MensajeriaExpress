package com.example.finalProject.model;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.util.UUID;

public class DeliveryResponse {
    private String guideNumber;
    private String deliveryStatus;

    public DeliveryResponse(){}
    public DeliveryResponse(String guideNumber, String deliveryStatus) {
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
