package com.example.finalProject.service;

import com.example.finalProject.dto.DeliveryResponseDTO;
import com.example.finalProject.dto.DeliveryStatusDTO;
import com.example.finalProject.dto.newDeliveryDTO;
import com.example.finalProject.dto.DeliveryConfirmationDTO;
import com.example.finalProject.exception.DataNotFoundException;
import com.example.finalProject.exception.InvalidDataException;
import com.example.finalProject.model.*;
import com.example.finalProject.model.Package;
import com.example.finalProject.repository.ClientRepository;
import com.example.finalProject.repository.DeliveryRepository;
import com.example.finalProject.repository.EmployeeRepository;
import com.example.finalProject.repository.PackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DeliveryService {

    private final DeliveryRepository deliveryRepository;
    private final PackageRepository packageRepository;
    private final ClientRepository clientRepository;
    private final EmployeeRepository employeeRepository;

    @Autowired
    public DeliveryService(DeliveryRepository deliveryRepository, PackageRepository packageRepository, ClientRepository clientRepository, EmployeeRepository employeeRepository) {
        this.deliveryRepository = deliveryRepository;
        this.packageRepository = packageRepository;
        this.clientRepository = clientRepository;
        this.employeeRepository = employeeRepository;
    }

    public DeliveryConfirmationDTO createDelivery(newDeliveryDTO newDeliveryDTO){
        if(newDeliveryDTO.getDestinationCity()==null ||
        newDeliveryDTO.getIdClient()==null || newDeliveryDTO.getWeight() == null||
        newDeliveryDTO.getPackageDeclaredValue()==null || newDeliveryDTO.getReceiverName()==null||
        newDeliveryDTO.getReceiverPhoneNumber()== null|| newDeliveryDTO.getDestinationAddress()==null
                || newDeliveryDTO.getOriginCity()==null){
            System.out.println(newDeliveryDTO);
            throw new InvalidDataException("Please fill all the information");
        }

        Optional<Client> optionalClient = this.clientRepository.findById(newDeliveryDTO.getIdClient());
        if(optionalClient.isEmpty()){
            throw new DataNotFoundException("The client with id "+ newDeliveryDTO.getIdClient()+" must be registered to send a package.");
        }
        String packageType;
        double deliveryValue;
        if(newDeliveryDTO.getWeight()<2){
            packageType = "Light";
            deliveryValue = 30000;
        }else if(newDeliveryDTO.getWeight()<=2 && newDeliveryDTO.getWeight()>5){
            packageType = "Medium";
            deliveryValue = 40000;
        }else if(newDeliveryDTO.getWeight()>=5){
            packageType = "Large";
            deliveryValue = 50000;
        }else{
            throw new InvalidDataException("The weight is not valid");
        }

        Package package1 = new Package(packageType, newDeliveryDTO.getWeight(), newDeliveryDTO.getPackageDeclaredValue());
        packageRepository.save(package1);

        Delivery delivery = new Delivery(optionalClient.get(),package1, newDeliveryDTO.getDestinationCity(), newDeliveryDTO.getOriginCity(), newDeliveryDTO.getDestinationAddress(), newDeliveryDTO.getReceiverName(), newDeliveryDTO.getReceiverPhoneNumber(),"Received",deliveryValue);
        deliveryRepository.save(delivery);

        return new DeliveryConfirmationDTO(delivery.getGuideNumber(), delivery.getDeliveryStatus());
    }

    public DeliveryResponseDTO getDelivery(String guideNumber){
      Optional<Delivery> optionalDelivery = this.deliveryRepository.findById(guideNumber);
      if(optionalDelivery.isEmpty()){
          throw new DataNotFoundException("The delivery with guide number "+guideNumber+" is not registered");
      }
      Delivery delivery = optionalDelivery.get();
        return new DeliveryResponseDTO(delivery.getClient().getId(), delivery.getOriginCity(),delivery.getDestinationCity(),
                delivery.getDestinationAddress(),delivery.getReceiverName(),delivery.getReceiverPhoneNumber(),delivery.getPackage1().getDeclaredValue(),
                delivery.getPackage1().getWeight(), delivery.getDeliveryValue(),delivery.getDeliveryStatus(), delivery.getGuideNumber());
    }


    public List<DeliveryResponseDTO> filterByStatus(String status, Long employeeId) {
        Optional<Employee> optionalEmployee = this.employeeRepository.findById(employeeId);
        if(optionalEmployee.isEmpty()){
            throw new DataNotFoundException("The employee with id "+employeeId+" is not registered in our company.");
        }
        return this.deliveryRepository.filterByStatus(status)
                .stream()
                .map(delivery -> new DeliveryResponseDTO(delivery.getClient().getId(),
                        delivery.getOriginCity(),
                        delivery.getDestinationCity(),
                        delivery.getDestinationAddress(),
                        delivery.getReceiverName(),
                        delivery.getReceiverPhoneNumber(),
                        delivery.getPackage1().getDeclaredValue(),
                        delivery.getPackage1().getWeight(),
                        delivery.getDeliveryValue(),
                        delivery.getDeliveryStatus(),
                        delivery.getGuideNumber())).collect(Collectors.toList());
    }

    public void updateStatus(){

    }
}
