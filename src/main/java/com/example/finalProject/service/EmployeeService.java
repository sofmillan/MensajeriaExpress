package com.example.finalProject.service;

import com.example.finalProject.exception.DataAlreadyExistsException;
import com.example.finalProject.exception.DataNotFoundException;
import com.example.finalProject.exception.DeletedSuccessfully;
import com.example.finalProject.exception.InvalidDataException;
import com.example.finalProject.model.Employee;
import com.example.finalProject.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
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
            throw new DataAlreadyExistsException("Id already exists");
        }
        if(validateEmail(employee.getEmail()) && validateType(employee.getType()) && validateId(employee.getId())){
            return this.employeeRepository.save(employee);
        }
       throw new InvalidDataException("Data is not valid");
    }



    public Employee getEmployee(Long id) {
        Optional<Employee> optionalEmployee = this.employeeRepository.findById(id);
        if(optionalEmployee.isEmpty()){
            throw new DataNotFoundException("The employee with id "+id+" does not exist");
        }
        return optionalEmployee.get();
    }


    public List<Employee> getEmployees() {
        return this.employeeRepository.findAll();
    }

    public ResponseEntity<Object> deleteEmployee(Long id) {
        Optional<Employee> optionalEmployee = this.employeeRepository.findById(id);
        if(optionalEmployee.isEmpty()){
            throw new DataNotFoundException("Id does not exist");
        }
        this.employeeRepository.deleteById(id);
       throw new DeletedSuccessfully("Employee with id "+id+" deleted successfully");
    }

       public Employee updateEmployee(Long id, Employee employee) {
           Optional<Employee> optionalEmployee = this.employeeRepository.findById(id);
           if(optionalEmployee.isEmpty()){
               throw new DataNotFoundException("The employee with id "+id+"does not exist");
           }
           optionalEmployee.get().setName(employee.getName());
           optionalEmployee.get().setAddress(employee.getAddress());
           optionalEmployee.get().setCity(employee.getCity());
           optionalEmployee.get().setLastName(employee.getLastName());
           optionalEmployee.get().setEmail(employee.getEmail());;
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
        if(type.equalsIgnoreCase("Coordinator")||
                type.equalsIgnoreCase("Driver")||
                type.equalsIgnoreCase("Delivery")){
            return true;
        }
        return false;
    }

    public boolean validateId(Long id){
        String s = Long.toString(id);
        return s.length() <= 10;
    }
}

