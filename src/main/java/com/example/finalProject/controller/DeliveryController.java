package com.example.finalProject.controller;

import com.example.finalProject.dto.DeliveryResponseDTO;
import com.example.finalProject.dto.DeliveryStatusDTO;
import com.example.finalProject.model.Delivery;
import com.example.finalProject.dto.newDeliveryDTO;
import com.example.finalProject.dto.DeliveryConfirmationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.finalProject.service.DeliveryService;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class DeliveryController {

    private final DeliveryService deliveryService;

    @Autowired
    public DeliveryController(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @PostMapping("/delivery")
    public DeliveryConfirmationDTO createDelivery(@RequestBody newDeliveryDTO newDeliveryDTO){
       return this.deliveryService.createDelivery(newDeliveryDTO);
    }

    @GetMapping("/delivery/{guideNumber}")
    public DeliveryResponseDTO getDelivery(@PathVariable String guideNumber){
        return this.deliveryService.getDelivery(guideNumber);
    }

    @GetMapping("/delivery")
    public List<DeliveryResponseDTO> filterByStatus(@RequestParam String status, @RequestParam Long employeeId){
        return this.deliveryService.filterByStatus(status, employeeId);
    }
    @PutMapping("/delivery")
    public void updateStatus(){
         this.deliveryService.updateStatus();
    }

}
