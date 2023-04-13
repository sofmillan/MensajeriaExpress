package com.example.finalProject.controller;

import com.example.finalProject.model.DeliveryDTO;
import com.example.finalProject.model.DeliveryResponse;
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
    public DeliveryResponse DeliveryResponse(@RequestBody  DeliveryDTO deliveryDTO){
       return this.deliveryService.createDelivery(deliveryDTO);
    }
}
