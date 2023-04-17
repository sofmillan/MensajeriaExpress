package com.example.finalProject.service;

import com.example.finalProject.exception.DataAlreadyExistsException;
import com.example.finalProject.exception.DataNotFoundException;
import com.example.finalProject.exception.DeletedSuccessfully;
import com.example.finalProject.exception.InvalidDataException;
import com.example.finalProject.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.finalProject.repository.ClientRepository;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client addClient(Client client){
        Optional<Client> optionalClient = clientRepository.findById(client.getId());
        if(optionalClient.isPresent()){
            throw new DataAlreadyExistsException("Id already exists");
        }
        if(!validateEmail(client.getEmail()) ){
            throw new InvalidDataException("Email is not valid");
        }
        if(!validateId(client.getId())){
            throw new InvalidDataException("Id is not valid");
        }
        return this.clientRepository.save(client);
    }

    public Client getClient(Long id){
        Optional<Client> optionalClient = this.clientRepository.findById(id);
        if(optionalClient.isEmpty()){
            throw new DataNotFoundException("The client with id "+id+" does not exist");
        }
        return optionalClient.get();
    }

    public List<Client> getClients(){
        return this.clientRepository.findAll();
    }

    public ResponseEntity<Object> deleteClient(Long id){
        Optional<Client> optionalClient = this.clientRepository.findById(id);
        if(optionalClient.isEmpty()){
            throw new DataNotFoundException("Id does not exist");
        }
        this.clientRepository.deleteById(id);
        return new ResponseEntity<>(new DeletedSuccessfully("Client with id "+id+" deleted successfully"),  HttpStatus.OK);
    }


    public Client updateClient(Long id, Client client){
        Optional<Client> optionalClient = this.clientRepository.findById(id);
        if(optionalClient.isEmpty()){
            throw new DataNotFoundException("The client with id "+id+" does not exist");
        }
        optionalClient.get().setName(client.getName());
        optionalClient.get().setAddress(client.getAddress());
        optionalClient.get().setCity(client.getCity());
        optionalClient.get().setLastName(client.getLastName());
        optionalClient.get().setEmail(client.getEmail());;
        optionalClient.get().setPhoneNumber(client.getPhoneNumber());
        optionalClient.get().setId(id);

        return this.clientRepository.save(optionalClient.get());
    }

    public boolean validateEmail(String email) {
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher matcher = pattern.matcher(email);
        return matcher.find();
    }
    public boolean validateId(Long id){
        String idString = Long.toString(id);
        return idString.length() <= 10;
    }
}
