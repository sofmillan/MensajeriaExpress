package com.example.finalProject.controller;

import com.example.finalProject.model.Delivery;
import com.example.finalProject.model.DeliveryDTO;
import com.example.finalProject.model.DeliveryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.finalProject.service.DeliveryService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1")
public class DeliveryController {

    private final DeliveryService deliveryService;

    @Autowired
    public DeliveryController(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @PostMapping("/delivery")
    public DeliveryResponse createDelivery(@RequestBody  DeliveryDTO deliveryDTO){
       return this.deliveryService.createDelivery(deliveryDTO);
    }

    @GetMapping("/delivery/{guideNumber}")
    public Delivery getDelivery(@PathVariable String guideNumber){
        return this.deliveryService.getDelivery(guideNumber);
    }

    @GetMapping("/delivery")
    public List<Delivery> filterByStatus(@RequestParam String status, @RequestParam Long employeeId){
        return this.deliveryService.filterByStatus(status, employeeId);
    }

}
