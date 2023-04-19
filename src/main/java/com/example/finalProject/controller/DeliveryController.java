package com.example.finalProject.controller;

import com.example.finalProject.dto.*;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.example.finalProject.service.DeliveryService;

import java.util.List;

@Api(tags="Delivery")
@RestController
@RequestMapping("api/v1")
public class DeliveryController {

    private final DeliveryService deliveryService;

    @Autowired
    public DeliveryController(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @ApiOperation(value = "Create a new delivery")
    @ApiResponses( value= {
            @ApiResponse(code = 200, message = "Delivery created successfully"),
            @ApiResponse(code = 400, message = "Data is not valid, check the input")
    })
    @PostMapping("/delivery")
    public ResponseEntity<DeliveryConfirmationDTO> createDelivery(@ApiParam("Delivery's information") @RequestBody newDeliveryDTO newDeliveryDTO){
        DeliveryConfirmationDTO confirmation = this.deliveryService.createDelivery(newDeliveryDTO);
        return ResponseEntity.ok(confirmation);
    }

    @ApiOperation(value = "Get a delivery by a specific id")
    @ApiResponses( value= {
            @ApiResponse(code = 200, message = "Delivery updated successfully"),
            @ApiResponse(code = 400, message = "Data is not valid, check the input")
    })
    @GetMapping("/delivery/{guideNumber}")
    public ResponseEntity<DeliveryResponseDTO>  getDelivery(@ApiParam("Delivery's id") @PathVariable String guideNumber){
        DeliveryResponseDTO foundDelivery = this.deliveryService.getDelivery(guideNumber);
        return ResponseEntity.ok(foundDelivery);
    }

    @ApiOperation(value = "Filter deliveries by status")
    @ApiResponses( value= {
            @ApiResponse(code = 200, message = "Deliveries retrieved successfully"),
            @ApiResponse(code = 400, message = "Data is not valid, check the input")
    })
    @PreAuthorize("hasRole('READ')")
    @GetMapping("/delivery")
    public List<DeliveryResponseDTO> filterByStatus(@ApiParam("Delivery status (e.g Received)")@RequestParam String status, @ApiParam("Employee's id (e.g 123)")@RequestParam Long employeeId){
        return this.deliveryService.filterByStatus(status, employeeId);
    }

    @ApiOperation(value = "Update a delivery's information by a specific id")
    @ApiResponses( value= {
            @ApiResponse(code = 200, message = "Delivery updated successfully"),
            @ApiResponse(code = 400, message = "Data is not valid, check the input"),
            @ApiResponse(code = 401, message = "You must authenticate to get a response"),
            @ApiResponse(code = 403, message = "You do not have access to this content"),
            @ApiResponse(code = 500, message = "Data not found")
    })
    @PreAuthorize("hasRole('WRITE')")
    @PutMapping("/delivery")
    public ResponseEntity<DeliveryStatusDTO> updateStatus(@ApiParam("Updated delivery information") @RequestBody DeliveryUpdateRequestDTO deliveryUpdate){
        DeliveryStatusDTO statusUpdate = this.deliveryService.updateStatus(deliveryUpdate);
        return ResponseEntity.ok(statusUpdate);
    }

}
