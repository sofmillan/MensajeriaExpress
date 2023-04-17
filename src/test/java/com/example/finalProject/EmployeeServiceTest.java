package com.example.finalProject;

import com.example.finalProject.repository.ClientRepository;
import com.example.finalProject.service.ClientService;
import org.junit.Before;

import static org.mockito.Mockito.mock;

public class EmployeeServiceTest {
    ClientRepository clientRepository;
    ClientService  clientService;

    @Before
    public void setUp(){
        this.clientRepository=mock(ClientRepository.class);
        this.clientService= new ClientService(clientRepository);
    }
}
