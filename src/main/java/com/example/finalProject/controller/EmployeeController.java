package com.example.finalProject.controller;

import com.example.finalProject.model.Employee;
import com.example.finalProject.service.EmployeeService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @ApiOperation(value = "Create a new employee")
    @PostMapping("/employee")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        Employee emp1 = employeeService.addEmployee(employee);
        return ResponseEntity.ok(emp1);
    }

    @ApiOperation(value = "Get an employee's information by a specific id")
    @GetMapping("/employee/{id}")
    public Employee getEmployeeById(@PathVariable Long id){
        return this.employeeService.getEmployee(id);
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        return this.employeeService.getEmployees();
    }

    @ApiOperation(value = "Delete an employee by a specific id")
    @DeleteMapping("/employee/{id}")
    public ResponseEntity<Object> deleteEmployee(@PathVariable Long id){
        return this.employeeService.deleteEmployee(id);
    }
    @ApiOperation(value = "Update an employee's information by a specific id")
    @PutMapping("/employee/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee){
        return this.employeeService.updateEmployee(id, employee);
    }


}
