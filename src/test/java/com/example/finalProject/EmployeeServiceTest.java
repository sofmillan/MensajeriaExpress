package com.example.finalProject;

import com.example.finalProject.exception.DataAlreadyExistsException;
import com.example.finalProject.exception.DataNotFoundException;
import com.example.finalProject.exception.InvalidDataException;
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
    public void Should_FindEmployee_When_GetEmployee(){
        Employee employee = new Employee(1L,"Sofia","Millan",123123L,"isabellagmail.com",
                "Cll26","Medellín",1,"o+","coordinator");

        when(employeeRepository.findById(employee.getId())).thenReturn(Optional.of(employee));

        Optional<Employee> optionalEmployee = employeeRepository.findById(employee.getId());

        assertTrue(optionalEmployee.isPresent());

    }

    @Test(expected = DataNotFoundException.class)
    public void Should_ThrowException_When_GetEmployee_IdNotFound(){
        Long id = 123L;
        when(employeeRepository.findById(id)).thenReturn(Optional.empty());

        Employee employee = this.employeeService.getEmployee(id);

        verify(employeeRepository.findById(employee.getId()));
    }

    @Test(expected = DataAlreadyExistsException.class)
    public void Should_ThrowException_When_IdExists(){
        Employee employee1 = new Employee(1L,"Sofia","Millan",123123L,"isabella@gmail.com",
                "Cll26","Medellín",1,"o+","coordinator");
        Employee employee2 = new Employee(1L,"Sofia","Millan",123123L,"isabella@gmail.com",
                "Cll26","Medellín",1,"o+","coordinator");

        when(employeeRepository.save(employee2)).thenThrow(DataAlreadyExistsException.class);

        Employee createdEmployee1 = this.employeeService.addEmployee(employee1);
        Employee createdEmployee2 = this.employeeService.addEmployee(employee2);

        verify(employeeRepository.save(createdEmployee2));
    }

    @Test(expected = DataNotFoundException.class)
    public void Should_ThrowException_When_UpdateEmployee_IdNotFound(){
        Long id = 123L;
        when(employeeRepository.findById(id)).thenReturn(Optional.empty());

        Employee employee = this.employeeService.updateEmployee(id, new Employee(1L,"Sofia","Millan",123123L,"isabella@gmail.com",
                "Cll26","Medellín",1,"o+","coordinator") );

        verify(employeeRepository.save(employee));
    }

    @Test
    public void CreateEmployeeTest(){
        Employee employee = new Employee(1L,"Sofia","Millan",123123L,"isabella@gmail.com",
                "Cll26","Medellín",1,"o+","coordinator");

        Employee createdEmployee = this.employeeService.addEmployee(employee);
        verify(employeeRepository).save(employee);
    }

}
