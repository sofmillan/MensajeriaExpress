package com.example.finalProject.controller;

import com.example.finalProject.model.Employee;
import com.example.finalProject.service.EmployeeService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


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
    @PreAuthorize("hasAuthority('WRITE')")
    @PostMapping("/employee")
    public ResponseEntity<Employee> addEmployee(@ApiParam("Employee's information") @RequestBody Employee employee) {
        Employee createdEmployee = employeeService.addEmployee(employee);
        return ResponseEntity.ok(createdEmployee);
    }

    @ApiOperation(value = "Get an employee's information by a specific id")
    @ApiResponses( value= {
            @ApiResponse(code = 200, message = "Employee was found"),
            @ApiResponse(code = 500, message = "Employee not found"),
    })
    @PreAuthorize("hasAuthority('READ')")
    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getEmployeeById(@ApiParam("Employee's id (e.g 123)") @PathVariable Long id){
        Employee foundEmployee = this.employeeService.getEmployee(id);
        return ResponseEntity.ok(foundEmployee);
    }

    @ApiOperation(value = "Delete an employee by a specific id")
    @ApiResponses( value= {
            @ApiResponse(code = 200, message = "Employee was deleted successfully"),
            @ApiResponse(code = 401, message = "You must authenticate to get a response"),
            @ApiResponse(code = 403, message = "You do not have access to this content"),
            @ApiResponse(code = 500, message = "Employee not found")
    })
    @PreAuthorize("hasAuthority('WRITE')")
    @DeleteMapping("/employee/{id}")
    public ResponseEntity<Object> deleteEmployee(@ApiParam("Employee's id (e.g 123)") @PathVariable Long id){
        return this.employeeService.deleteEmployee(id);
    }
    @ApiOperation(value = "Update an employee's information by a specific id")
    @ApiResponses( value= {
            @ApiResponse(code = 200, message = "Employee updated successfully"),
            @ApiResponse(code = 400, message = "Data is not valid, check the input"),
            @ApiResponse(code = 401, message = "You must authenticate to get a response"),
            @ApiResponse(code = 403, message = "You do not have access to this content"),
            @ApiResponse(code = 500, message = "Employee not found")
    })
    @PreAuthorize("hasAuthority('WRITE')")
    @PutMapping("/employee/{id}")
    public ResponseEntity<Employee> updateEmployee(@ApiParam("Employee's id (e.g 123)") @PathVariable Long id,
                                   @ApiParam("Updated employee's information")@RequestBody Employee employee){
        Employee updatedEmployee = this.employeeService.updateEmployee(id, employee);
        return ResponseEntity.ok(updatedEmployee);
    }


}
