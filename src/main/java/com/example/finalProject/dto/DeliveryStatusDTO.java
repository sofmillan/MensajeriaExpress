package com.example.finalProject.dto;

public class DeliveryStatusDTO {
    private String guideNumber;
    private String lastStatus;

    public DeliveryStatusDTO(){
    }
    public DeliveryStatusDTO(String guideNumber, String lastStatus) {
        this.guideNumber = guideNumber;
        this.lastStatus = lastStatus;
    }

    public String getGuideNumber() {
        return guideNumber;
    }

    public String getLastStatus() {
        return lastStatus;
    }
}
