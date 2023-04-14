package com.example.finalProject.service;

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

    public DeliveryResponse createDelivery(DeliveryDTO deliveryDTO){
        if(deliveryDTO.getDestinationCity()==null ||
        deliveryDTO.getIdClient()==null || deliveryDTO.getWeight() == null||
        deliveryDTO.getPackageDeclaredValue()==null || deliveryDTO.getReceiverName()==null||
        deliveryDTO.getReceiverPhoneNumber()== null|| deliveryDTO.getDestinationAddress()==null
                || deliveryDTO.getOriginCity()==null){
            System.out.println(deliveryDTO);
            throw new InvalidDataException("Please fill all the information");
        }

        Optional<Client> optionalClient = this.clientRepository.findById(deliveryDTO.getIdClient());
        if(optionalClient.isEmpty()){
            throw new DataNotFoundException("The client with id "+deliveryDTO.getIdClient()+" must be registered to send a package.");
        }
        String packageType;
        double deliveryValue;
        if(deliveryDTO.getWeight()<2){
            packageType = "Light";
            deliveryValue = 30000;
        }else if(deliveryDTO.getWeight()<=2 && deliveryDTO.getWeight()>5){
            packageType = "Medium";
            deliveryValue = 40000;
        }else if(deliveryDTO.getWeight()>=5){
            packageType = "Large";
            deliveryValue = 50000;
        }else{
            throw new InvalidDataException("The weight is not valid");
        }

        Package package1 = new Package(packageType,deliveryDTO.getWeight(),deliveryDTO.getPackageDeclaredValue());
        packageRepository.save(package1);

        Delivery delivery = new Delivery(optionalClient.get(),package1,deliveryDTO.getDestinationCity(),deliveryDTO.getOriginCity(),deliveryDTO.getDestinationAddress(), deliveryDTO.getReceiverName(),deliveryDTO.getReceiverPhoneNumber(),"Received",deliveryValue);
        deliveryRepository.save(delivery);

        return new DeliveryResponse(delivery.getGuideNumber(), delivery.getDeliveryStatus());
    }

    public Delivery getDelivery(String guideNumber){
      Optional<Delivery> optionalDelivery = this.deliveryRepository.findById(guideNumber);
      if(optionalDelivery.isEmpty()){
          throw new DataNotFoundException("The delivery with guide number "+guideNumber+" is not registered");
      }
        return optionalDelivery.get();
    }

    public List<Delivery> filterByStatus(String status, Long employeeId) {
        Optional<Employee> optionalEmployee = this.employeeRepository.findById(employeeId);
        if(optionalEmployee.isEmpty()){
            throw new DataNotFoundException("The employee with id "+employeeId+" is not registered in our company.");
        }
        return this.deliveryRepository.filterByStatus(status);
    }
}
