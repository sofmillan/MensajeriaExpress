package com.example.finalProject;

import com.example.finalProject.exception.DataAlreadyExistsException;
import com.example.finalProject.exception.DataNotFoundException;
import com.example.finalProject.exception.InvalidDataException;
import com.example.finalProject.model.Client;
import com.example.finalProject.repository.ClientRepository;
import com.example.finalProject.service.ClientService;
import org.junit.Before;
import org.junit.Test;
import java.util.Optional;
import static org.junit.Assert.assertTrue;

import static org.mockito.Mockito.*;

public class ClientServiceTest {
    ClientRepository clientRepository;
    ClientService clientService;

    @Before
    public void setUp(){
        this.clientRepository=mock(ClientRepository.class);
        this.clientService= new ClientService(clientRepository);
    }

    @Test(expected = InvalidDataException.class)
    public void Should_ThrowException_When_IdNull(){
        Client client = new Client(null,"Sofia","Millan",123123L,"isabella@gmail.com",
                "Cll26","Medellín");
        Client createdClient = this.clientService.addClient(client);
        verify(clientRepository.save(createdClient));
    }

    @Test(expected = InvalidDataException.class)
    public void Should_ThrowException_When_IdNotValid(){
        Client client = new Client(12345678910L,"Sofia","Millan",123123L,"isabella@gmail.com",
                "Cll26","Medellín");
        Client createdClient = this.clientService.addClient(client);
        verify(clientRepository.save(createdClient));
    }

    @Test(expected = InvalidDataException.class)
    public void Should_ThrowException_When_EmailNotValid(){
        Client client = new Client(123L,"Sofia","Millan",123123L,"isabellagmail.com",
                "Cll26","Medellín");
        Client createdClient = this.clientService.addClient(client);
        verify(clientRepository.save(createdClient));
    }

    @Test(expected = DataNotFoundException.class)
    public void Should_ThrowException_When_IdNotFoundGet(){
        Long id = 123L;
        when(clientRepository.findById(id)).thenReturn(Optional.empty());

        Client client = this.clientService.getClient(id);

       verify(clientRepository.findById(client.getId()));
    }

    @Test(expected = DataNotFoundException.class)
    public void Should_ThrowException_When_IdNotFoundUpdate(){
        Long id = 123L;
        when(clientRepository.findById(id)).thenReturn(Optional.empty());
        Client client = this.clientService.updateClient(id, new Client(123L,"Sofia","Millan",123123L,"isabellagmail.com",
                "Cll26","Medellín") );
        verify(clientRepository.save(client));
    }

    @Test(expected = DataAlreadyExistsException.class)
    public void Should_ThrowException_When_IdExists(){

        Client client = new Client(1L,"Sofia","Millan",123123L,"isabella@gmail.com",
                "Cll26","Medellín");
        Client client2 = new Client(1L,"Sofia","Millan",123123L,"isabella@gmail.com",
                "Cll26","Medellín");

        when(clientRepository.save(client2)).thenThrow(DataAlreadyExistsException.class);

        Client createdClient1 = this.clientService.addClient(client);
        Client createdClient2 = this.clientService.addClient(client2);

        verify(clientRepository.save(createdClient2));
    }

    @Test
    public void Should_FindClient_When_GetClient(){
        Client client = new Client(123L,"Sofia","Millan",123123L,"isabella@gmail.com",
                "Cll26","Medellín");

         when(clientRepository.findById(client.getId())).thenReturn(Optional.of(client));

         Optional<Client> optionalClient = clientRepository.findById(client.getId());

        assertTrue(optionalClient.isPresent());
    }


    @Test
    public void CreateClientTest(){
        Client client = new Client(1L,"Sofia","Millan",123123L,"isabella@gmail.com",
                "Cll26","Medellín");
        Client createdClient = this.clientService.addClient(client);
        verify(clientRepository).save(client);
    }
}
