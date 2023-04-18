package com.example.finalProject;

import com.example.finalProject.exception.DataAlreadyExistsException;
import com.example.finalProject.exception.InvalidDataException;

import com.example.finalProject.model.Client;
import com.example.finalProject.repository.EmployeeRepository;

import com.example.finalProject.model.Employee;
import com.example.finalProject.service.EmployeeService;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class EmployeeServiceTest {
    EmployeeRepository employeeRepository;
    EmployeeService employeeService;

    @Before
    public void setUp(){
        this.employeeRepository=mock(EmployeeRepository.class);
        this.employeeService= new EmployeeService(employeeRepository);
    }

    @Test(expected = InvalidDataException.class)
    public void Should_ThrowException_When_IdNull(){
        Employee employee = new Employee(null,"Sofia","Millan",123123L,"isabella@gmail.com",
                "Cll26","Medellín",1,"o+","coordinator");
        Employee createdEmployee = this.employeeService.addEmployee(employee);
        verify(employeeRepository.save(createdEmployee));
    }
    @Test(expected = InvalidDataException.class)
    public void Should_ThrowException_When_IdNotValid(){
        Employee employee = new Employee(12345678912L,"Sofia","Millan",123123L,"isabella@gmail.com",
                "Cll26","Medellín",1,"o+","coordinator");
        Employee createdEmployee = this.employeeService.addEmployee(employee);
        verify(employeeRepository.save(createdEmployee));
    }

    @Test(expected = InvalidDataException.class)
    public void Should_ThrowException_When_EmployeeTypeNull(){
        Employee employee = new Employee(1L,"Sofia","Millan",123123L,"isabella@gmail.com",
                "Cll26","Medellín",1,"o+",null);
        Employee createdEmployee = this.employeeService.addEmployee(employee);
        verify(employeeRepository.save(createdEmployee));
    }
    @Test(expected = InvalidDataException.class)
    public void Should_ThrowException_When_EmployeeTypeInvalid(){
        Employee employee = new Employee(1L,"Sofia","Millan",123123L,"isabella@gmail.com",
                "Cll26","Medellín",1,"o+","Customer Service");
        Employee createdEmployee = this.employeeService.addEmployee(employee);
        verify(employeeRepository.save(createdEmployee));
    }

    @Test(expected = InvalidDataException.class)
    public void Should_ThrowException_When_EmailNotValid(){
        Employee employee = new Employee(1L,"Sofia","Millan",123123L,"isabellagmail.com",
                "Cll26","Medellín",1,"o+","coordinator");
        Employee createdEmployee = this.employeeService.addEmployee(employee);
        verify(employeeRepository.save(createdEmployee));
    }

    @Test
    public void GetEmployee_FoundClient(){
        Employee employee = new Employee(1L,"Sofia","Millan",123123L,"isabellagmail.com",
                "Cll26","Medellín",1,"o+","coordinator");

        when(employeeRepository.findById(employee.getId())).thenReturn(Optional.of(employee));

        Optional<Employee> optionalEmployee = employeeRepository.findById(employee.getId());

        assertTrue(optionalEmployee.isPresent());

    }

 /*   @Test(expected = DataAlreadyExistsException.class)
    public void Should_ThrowException_When_IdAlreadyExists(){


    }*/


}
