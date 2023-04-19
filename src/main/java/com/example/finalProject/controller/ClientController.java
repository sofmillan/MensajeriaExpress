package com.example.finalProject.controller;

import com.example.finalProject.model.Client;
import com.example.finalProject.service.ClientService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@Api(tags="Client")
@RestController
@RequestMapping("api/v1")
public class ClientController {
    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @ApiOperation(value = "Create a new client")
    @ApiResponses( value= {
            @ApiResponse(code = 200, message = "Client created successfully"),
            @ApiResponse(code = 400, message = "Data is not valid, check the input"),
            @ApiResponse(code = 409, message = "Client already exists, check the id"),
    })
    @PostMapping("/public")
    public ResponseEntity<Client> addClient(@ApiParam("Client's information") @RequestBody Client client){
        Client createdClient = this.clientService.addClient(client);
        return ResponseEntity.ok(createdClient);
    }


    @ApiOperation(value = "Get a client's information by a specific id")
    @ApiResponses( value= {
            @ApiResponse(code = 200, message = "Client was found"),
            @ApiResponse(code = 500, message = "Client not found"),
    })
    @GetMapping("client/{id}")
    public ResponseEntity<Client> getClientById(@ApiParam("Client's id (e.g 123)")  @PathVariable Long id){
        Client foundClient = this.clientService.getClient(id);
        return ResponseEntity.ok(foundClient);
    }


    @ApiOperation(value = "Delete a client by a specific id")
    @ApiResponses( value= {
            @ApiResponse(code = 200, message = "Client was found"),
            @ApiResponse(code = 500, message = "Client not found"),
    })
    @PreAuthorize("hasRole('WRITE')")
    @DeleteMapping("/client/{id}")
    public ResponseEntity<Object> deleteClient(@ApiParam("Client's id (e.g 123)") @PathVariable Long id){
        return this.clientService.deleteClient(id);
    }

    @ApiOperation(value = "Update a client's information by a specific id")
    @ApiResponses( value= {
            @ApiResponse(code = 200, message = "Client was updated successfully"),
            @ApiResponse(code = 400, message = "Data is not valid, check the input"),
            @ApiResponse(code = 500, message = "Client not found"),
    })
    @PreAuthorize("hasRole('WRITE')")
    @PutMapping("/client/{id}")
    public ResponseEntity<Client> updateClient(@ApiParam("Client's id (e.g 123)") @PathVariable Long id,
                                                @ApiParam("Updated client's information") @RequestBody Client client){
        Client updatedClient = this.clientService.updateClient(id, client);
        return ResponseEntity.ok(updatedClient);
    }
}
