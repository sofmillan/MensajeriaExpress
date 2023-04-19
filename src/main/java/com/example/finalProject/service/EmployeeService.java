package com.example.finalProject.service;

import com.example.finalProject.exception.DataAlreadyExistsException;
import com.example.finalProject.exception.DataNotFoundException;
import com.example.finalProject.exception.DeletedSuccessfully;
import com.example.finalProject.exception.InvalidDataException;
import com.example.finalProject.model.Employee;
import com.example.finalProject.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee addEmployee(Employee employee){
        Optional<Employee> optionalEmployee = employeeRepository.findById(employee.getId());
        if(optionalEmployee.isPresent()){
            throw new DataAlreadyExistsException("Id "+employee.getId()+ " already exists");
        }
        if(employee.getId()==null){
            throw new InvalidDataException("Please fill the id input");
        }
        if(employee.getType()==null){
            throw new InvalidDataException("Please fill the type input");
        }
        if(!validateEmail(employee.getEmail()) ){
            throw new InvalidDataException("Email is not valid");
        }
        if(!validateType(employee.getType())){
            throw new InvalidDataException("Employee type is not valid");
        }
        if(!validateId(employee.getId())){
            throw new InvalidDataException("Id is not valid");
        }
        return this.employeeRepository.save(employee);
    }


    public Employee getEmployee(Long id) {
        Optional<Employee> optionalEmployee = this.employeeRepository.findById(id);
        if(optionalEmployee.isEmpty()){
            throw new DataNotFoundException("The employee with id "+id+" does not exist");
        }
        return optionalEmployee.get();
    }

    public ResponseEntity<Object> deleteEmployee(Long id) {
        Optional<Employee> optionalEmployee = this.employeeRepository.findById(id);
        if(optionalEmployee.isEmpty()){
            throw new DataNotFoundException("The employee with id "+id+"does not exist");
        }
        this.employeeRepository.deleteById(id);
        return new ResponseEntity<>(new DeletedSuccessfully("Employee with id "+id+" deleted successfully"),  HttpStatus.OK);
    }

       public Employee updateEmployee(Long id, Employee employee) {
           Optional<Employee> optionalEmployee = this.employeeRepository.findById(id);
           if(optionalEmployee.isEmpty()){
               throw new DataNotFoundException("The employee with id "+id+" does not exist");
           }
           optionalEmployee.get().setName(employee.getName());
           optionalEmployee.get().setAddress(employee.getAddress());
           optionalEmployee.get().setCity(employee.getCity());
           optionalEmployee.get().setLastName(employee.getLastName());
           optionalEmployee.get().setEmail(employee.getEmail());
           optionalEmployee.get().setBloodType(employee.getBloodType());
           optionalEmployee.get().setSeniority(employee.getSeniority());
           optionalEmployee.get().setType(employee.getType());
           optionalEmployee.get().setPhoneNumber(employee.getPhoneNumber());
           optionalEmployee.get().setId(id);

           return this.employeeRepository.save(optionalEmployee.get());
    }

    public boolean validateEmail(String email){
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher matcher = pattern.matcher(email);
        return matcher.find();
    }
    public boolean validateType(String type){
        return type.equalsIgnoreCase("Coordinator") ||
                type.equalsIgnoreCase("Driver") ||
                type.equalsIgnoreCase("Delivery");
    }

    public boolean validateId(Long id){
        String s = Long.toString(id);
        return s.length() <= 10;
    }
}

