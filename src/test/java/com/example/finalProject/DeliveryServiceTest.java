package com.example.finalProject;


import com.example.finalProject.dto.*;
import com.example.finalProject.exception.DataNotFoundException;
import com.example.finalProject.exception.InvalidDataException;
import com.example.finalProject.model.Client;
import com.example.finalProject.model.Employee;
import com.example.finalProject.model.Delivery;
import com.example.finalProject.repository.DeliveryRepository;
import com.example.finalProject.repository.EmployeeRepository;
import com.example.finalProject.repository.PackageRepository;
import com.example.finalProject.service.DeliveryService;
import org.junit.Before;
import com.example.finalProject.repository.ClientRepository;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.testng.AssertJUnit.*;

public class DeliveryServiceTest {

    ClientRepository clientRepository;
    EmployeeRepository employeeRepository;
    DeliveryRepository deliveryRepository;
    PackageRepository packageRepository;
    DeliveryService deliveryService;

    @Before
    public void setUp(){
        this.clientRepository = mock(ClientRepository.class);
        this.deliveryRepository = mock(DeliveryRepository.class);
        this.employeeRepository = mock(EmployeeRepository.class);
        this.packageRepository = mock(PackageRepository.class);
        this.deliveryService = new DeliveryService(deliveryRepository,packageRepository,clientRepository,employeeRepository);
    }

    @Test(expected = InvalidDataException.class)
    public void Should_ThrowException_When_ClientIdNull(){
        newDeliveryDTO newDelivery = new newDeliveryDTO(null,"Armenia","Medellin","Cll26",
                "Ricky",900900L,19000.0,1.0);
        DeliveryConfirmationDTO confirmation = this.deliveryService.createDelivery(newDelivery);
    }

    @Test(expected = InvalidDataException.class)
    public void Should_ThrowException_When_OriginCityNull(){
        newDeliveryDTO newDelivery = new newDeliveryDTO(123L,null,"Medellin","Cll26",
                "Ricky",900900L,19000.0,1.0);
        DeliveryConfirmationDTO confirmation = this.deliveryService.createDelivery(newDelivery);
    }
    @Test(expected = InvalidDataException.class)
    public void Should_ThrowException_When_DestinationCityNull(){
        newDeliveryDTO newDelivery = new newDeliveryDTO(123L,"Armenia",null,"Cll26",
                "Ricky",900900L,19000.0,1.0);
        DeliveryConfirmationDTO confirmation = this.deliveryService.createDelivery(newDelivery);
    }

    @Test(expected = InvalidDataException.class)
    public void Should_ThrowException_When_DestinationAddressNull(){
        newDeliveryDTO newDelivery = new newDeliveryDTO(123L,"Armenia","Medellín",null,
                "Ricky",900900L,19000.0,1.0);
        DeliveryConfirmationDTO confirmation = this.deliveryService.createDelivery(newDelivery);
    }
    @Test(expected = InvalidDataException.class)
    public void Should_ThrowException_When_ReceiverNameNull(){
        newDeliveryDTO newDelivery = new newDeliveryDTO(123L,"Armenia","Medellin","Cll26",
                null,900900L,19000.0,1.0);
        DeliveryConfirmationDTO confirmation = this.deliveryService.createDelivery(newDelivery);
    }

    @Test(expected = InvalidDataException.class)
    public void Should_ThrowException_When_ReceiverPhoneNumberNull(){
        newDeliveryDTO newDelivery = new newDeliveryDTO(123L,"Armenia",null,"Cll26",
                "Ricky",null,19000.0,1.0);
        DeliveryConfirmationDTO confirmation = this.deliveryService.createDelivery(newDelivery);
    }

    @Test(expected = InvalidDataException.class)
    public void Should_ThrowException_When_PackageDeclaredValueNull(){
        newDeliveryDTO newDelivery = new newDeliveryDTO(123L,"Armenia","Medellín","Cll26",
                "Ricky",900900L,null,1.0);
        DeliveryConfirmationDTO confirmation = this.deliveryService.createDelivery(newDelivery);
    }

    @Test(expected = InvalidDataException.class)
    public void Should_ThrowException_When_WeightNull(){
        newDeliveryDTO newDelivery = new newDeliveryDTO(123L,"Armenia","Medellín","Cll26",
                "Ricky",900900L,19000.0,null);
        DeliveryConfirmationDTO confirmation = this.deliveryService.createDelivery(newDelivery);
    }

    @Test(expected = DataNotFoundException.class)
    public void Should_ThrowException_When_IdClientNotFound(){
        newDeliveryDTO newDelivery = new newDeliveryDTO(123L,"Armenia","Medellín","Cll26",
                "Ricky",900900L,19000.0,1.0);

        when(clientRepository.findById(any())).thenReturn(Optional.empty());

        DeliveryConfirmationDTO confirmation = this.deliveryService.createDelivery(newDelivery);

        verify(clientRepository.findById(newDelivery.getIdClient()));
    }

    @Test(expected = DataNotFoundException.class)
    public void Should_ThrowException_When_FilterDeliveries_IdNotFound(){
        Long id = 123L;
        when(employeeRepository.findById(id)).thenReturn(Optional.empty());

        List<DeliveryResponseDTO> actualizacion = deliveryService.filterByStatus("Received",id);

        verify(employeeRepository.findById(id));
    }

    @Test(expected = DataNotFoundException.class)
    public void Should_ThrowException_When_UpdateDelivery_IdNotFound(){
        Long id = 123L;
        when(employeeRepository.findById(id)).thenReturn(Optional.empty());

        DeliveryStatusDTO update = deliveryService.updateStatus(new DeliveryUpdateRequestDTO("abc","On route",id));

        verify(employeeRepository.findById(id));
    }

    @Test(expected = DataNotFoundException.class)
    public void Should_ThrowException_When_UpdateDelivery_GuideNumberNotFound(){
        Long id = 123L;
        String guideNumber = "abcd";

        when(deliveryRepository.findById(guideNumber)).thenReturn(Optional.empty());

        DeliveryStatusDTO update = deliveryService.updateStatus(new DeliveryUpdateRequestDTO(guideNumber,"On route",id));

        verify(deliveryRepository.findById(guideNumber));
    }
    @Test(expected = InvalidDataException.class)
    public void Should_ThrowException_When_UpdateDelivery_InvalidStatus(){

        Client client = new Client(123L,"Sofia","Millan",123123L,"isabella@gmail.com",
                "Cll26","Medellín");
        when(clientRepository.findById(client.getId())).thenReturn(Optional.of(client));

        Employee employee = new Employee(123L,"Sofia","Millan",123123L,"isabella@gmail.com",
                "Cll26","Medellín",1,"o+","coordinator");
        when(employeeRepository.findById(employee.getId())).thenReturn(Optional.of(employee));

        newDeliveryDTO newDelivery = new newDeliveryDTO(client.getId(),"Armenia","Medellín","Cll26",
                "Ricky",900900L,19000.0,1.0);
        DeliveryConfirmationDTO confirmation = deliveryService.createDelivery(newDelivery);
        Delivery delivery1 = new Delivery(confirmation.getGuideNumber(), confirmation.getDeliveryStatus());
        when(deliveryRepository.findById(confirmation.getGuideNumber())).thenReturn(Optional.of(delivery1));


        DeliveryUpdateRequestDTO request= new DeliveryUpdateRequestDTO(confirmation.getGuideNumber(),"Deliveried",employee.getId());
        DeliveryStatusDTO update = deliveryService.updateStatus(request);
        Optional<Delivery> delivery = deliveryRepository.findById(confirmation.getGuideNumber());


        verify(deliveryRepository).save(delivery.get());
    }

    @Test
    public void Should_ThrowException_When_UpdateDelivery_InvalidStatus1(){

        Client client = new Client(123L,"Sofia","Millan",123123L,"isabella@gmail.com",
                "Cll26","Medellín");
        when(clientRepository.findById(client.getId())).thenReturn(Optional.of(client));

        Employee employee = new Employee(123L,"Sofia","Millan",123123L,"isabella@gmail.com",
                "Cll26","Medellín",1,"o+","coordinator");
        when(employeeRepository.findById(employee.getId())).thenReturn(Optional.of(employee));

        newDeliveryDTO newDelivery = new newDeliveryDTO(client.getId(),"Armenia","Medellín","Cll26",
                "Ricky",900900L,19000.0,1.0);
        DeliveryConfirmationDTO confirmation = deliveryService.createDelivery(newDelivery);
        Delivery delivery1 = new Delivery(confirmation.getGuideNumber(), confirmation.getDeliveryStatus());
        when(deliveryRepository.findById(confirmation.getGuideNumber())).thenReturn(Optional.of(delivery1));

        DeliveryUpdateRequestDTO request= new DeliveryUpdateRequestDTO(confirmation.getGuideNumber(),"On route",employee.getId());
        DeliveryUpdateRequestDTO request2= new DeliveryUpdateRequestDTO(confirmation.getGuideNumber(),"Received",employee.getId());
        DeliveryStatusDTO update = deliveryService.updateStatus(request);
        Optional<Delivery> delivery = deliveryRepository.findById(confirmation.getGuideNumber());

        verify(deliveryRepository).save(delivery.get());
    }

}