package com.example.finalProject.controller;

import com.example.finalProject.model.Client;
import com.example.finalProject.service.ClientService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

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
    @PostMapping("/client")
    public ResponseEntity<Client> addClient(@RequestBody Client client){
        Client client1 = this.clientService.addClient(client);
        return ResponseEntity.ok(client1);
    }

    @ApiOperation(value = "Get a client's information by a specific id")
    @ApiResponses( value= {
            @ApiResponse(code = 200, message = "Client was found"),
            @ApiResponse(code = 500, message = "Client not found"),
    })
    @GetMapping("client/{id}")
    public Client getClientById(@PathVariable Long id){
        return this.clientService.getClient(id);
    }

    @ApiIgnore
    @GetMapping("/clients")
    public List<Client> getClient(){
        return this.clientService.getClients();
    }

    @ApiOperation(value = "Delete a client by a specific id")
    @ApiResponses( value= {
            @ApiResponse(code = 200, message = "Client was found"),
            @ApiResponse(code = 500, message = "Client not found"),
    })
    @DeleteMapping("/client/{id}")
    public ResponseEntity<Object> deleteClient(@PathVariable Long id){
        return this.clientService.deleteClient(id);
    }

        @ApiOperation(value = "Update a client's information by a specific id")
    @ApiResponses( value= {
            @ApiResponse(code = 200, message = "Client was updated successfully"),
            @ApiResponse(code = 400, message = "Data is not valid, check the input"),
            @ApiResponse(code = 500, message = "Client not found"),
    })
    @PutMapping("/client/{id}")
    public Client updateClient(@PathVariable Long id, @RequestBody Client client){
        return this.clientService.updateClient(id, client);
    }
}
