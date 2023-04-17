package com.example.finalProject.controller;

import com.example.finalProject.dto.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
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
    public DeliveryConfirmationDTO createDelivery(@RequestBody newDeliveryDTO newDeliveryDTO){
       return this.deliveryService.createDelivery(newDeliveryDTO);
    }

    @ApiOperation(value = "Get a delivery by a specific id")
    @ApiResponses( value= {
            @ApiResponse(code = 200, message = "Delivery updated successfully"),
            @ApiResponse(code = 400, message = "Data is not valid, check the input")
    })
    @GetMapping("/delivery/{guideNumber}")
    public DeliveryResponseDTO getDelivery(@PathVariable String guideNumber){
        return this.deliveryService.getDelivery(guideNumber);
    }

    @ApiOperation(value = "Filter deliveries by status")
    @ApiResponses( value= {
            @ApiResponse(code = 200, message = "Deliveries retrieved successfully"),
            @ApiResponse(code = 400, message = "Data is not valid, check the input")
    })
    @GetMapping("/delivery")
    public List<DeliveryResponseDTO> filterByStatus(@RequestParam String status, @RequestParam Long employeeId){
        return this.deliveryService.filterByStatus(status, employeeId);
    }

    @ApiOperation(value = "Update a delivery's information by a specific id")
    @ApiResponses( value= {
            @ApiResponse(code = 200, message = "Delivery updated successfully"),
            @ApiResponse(code = 400, message = "Data is not valid, check the input"),
            @ApiResponse(code = 500, message = "Data not found"),
    })
    @PutMapping("/delivery")
    public DeliveryStatusDTO updateStatus(@RequestBody DeliveryUpdateRequestDTO deliveryUpdate){
         return this.deliveryService.updateStatus(deliveryUpdate);
    }

}
