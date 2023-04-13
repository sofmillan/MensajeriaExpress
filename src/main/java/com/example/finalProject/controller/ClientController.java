package com.example.finalProject.controller;

import com.example.finalProject.model.Client;
import com.example.finalProject.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class ClientController {
    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/client")
    public ResponseEntity<Client> addClient(@RequestBody Client client){
        Client client1 = this.clientService.addClient(client);
        return ResponseEntity.ok(client1);
    }

    @GetMapping("client/{id}")
    public Client getClientById(@PathVariable Long id){
        return this.clientService.getClient(id);
    }

    @GetMapping("/clients")
    public List<Client> getClient(){
        return this.clientService.getClients();
    }

    @DeleteMapping("/client/{id}")
    public ResponseEntity<Object> deleteClient(@PathVariable Long id){
        return this.clientService.deleteClient(id);
    }

    @PutMapping("/client/{id}")
    public Client updateClient(@PathVariable Long id, @RequestBody Client client){
        return this.clientService.updateClient(id, client);
    }
}
