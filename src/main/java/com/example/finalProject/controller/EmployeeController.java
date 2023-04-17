package com.example.finalProject.controller;

import com.example.finalProject.model.Employee;
import com.example.finalProject.service.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@Api(tags="Employee")
@RestController
@RequestMapping("api/v1")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @ApiOperation(value = "Create a new employee")
    @ApiResponses( value= {
            @ApiResponse(code = 200, message = "Employee created successfully"),
            @ApiResponse(code = 400, message = "Data is not valid, check the input"),
            @ApiResponse(code = 409, message = "Employee already exists, check the id"),
    })
    @PostMapping("/employee")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        Employee emp1 = employeeService.addEmployee(employee);
        return ResponseEntity.ok(emp1);
    }

    @ApiOperation(value = "Get an employee's information by a specific id")
    @ApiResponses( value= {
            @ApiResponse(code = 200, message = "Employee was found"),
            @ApiResponse(code = 500, message = "Employee not found"),
    })
    @GetMapping("/employee/{id}")
    public Employee getEmployeeById(@PathVariable Long id){
        return this.employeeService.getEmployee(id);
    }

    @ApiIgnore
    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        return this.employeeService.getEmployees();
    }

    @ApiOperation(value = "Delete an employee by a specific id")
    @ApiResponses( value= {
            @ApiResponse(code = 200, message = "Employee was deleted successfully"),
            @ApiResponse(code = 500, message = "Employee not found"),
    })
    @DeleteMapping("/employee/{id}")
    public ResponseEntity<Object> deleteEmployee(@PathVariable Long id){
        return this.employeeService.deleteEmployee(id);
    }
    @ApiOperation(value = "Update an employee's information by a specific id")
    @ApiResponses( value= {
            @ApiResponse(code = 200, message = "Employee updated successfully"),
            @ApiResponse(code = 400, message = "Data is not valid, check the input"),
            @ApiResponse(code = 500, message = "Employee not found"),
    }
    )
    @PutMapping("/employee/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee){
        return this.employeeService.updateEmployee(id, employee);
    }


}
