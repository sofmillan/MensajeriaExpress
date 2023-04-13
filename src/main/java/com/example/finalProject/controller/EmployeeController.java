package com.example.finalProject.controller;

import com.example.finalProject.model.Employee;
import com.example.finalProject.service.EmployeeService;
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

    @PostMapping("/employee")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        Employee emp1 = employeeService.addEmployee(employee);
        return ResponseEntity.ok(emp1);
    }
    @GetMapping("/employee/{id}")
    public Employee getEmployeeById(@PathVariable Long id){
        return this.employeeService.getEmployee(id);
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        return this.employeeService.getEmployees();
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<Object> deleteEmployee(@PathVariable Long id){
        return this.employeeService.deleteEmployee(id);
    }
    @PutMapping("/employee/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee){
        return this.employeeService.updateEmployee(id, employee);
    }


}
