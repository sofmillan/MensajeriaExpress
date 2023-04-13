package com.example.finalProject.controller;

import com.example.finalProject.model.DeliveryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.finalProject.service.DeliveryService;
@RestController
@RequestMapping("api/v1")
public class DeliveryController {

    private final DeliveryService deliveryService;

    @Autowired
    public DeliveryController(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @PostMapping("/delivery")
    public void createDelivery(@RequestBody  DeliveryDTO deliveryDTO){
        this.deliveryService.createDelivery(deliveryDTO);
    }
}
