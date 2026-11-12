package com.example.employee.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee.model.Employee;
import com.example.employee.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    private final EmployeeService empService;

    public EmployeeController(EmployeeService empService) {
        this.empService = empService;
    }

    // CREATE : POST /api/employees
    @PostMapping("/employees")
    @ResponseStatus(HttpStatus.CREATED)
    public Employee createEmployee(@RequestBody Employee emp) {
        return empService.createEmployee(emp);
    }

    // READ : GET /api/employees
    @GetMapping("/employees")
    public List<Employee> readEmployees() {
        return empService.getEmployees();
    }

    // UPDATE : PUT /api/employees/{empId}
    @PutMapping("/employees/{empId}")
    public Employee updateEmployee(@PathVariable("empId") Long id,
                                   @RequestBody Employee empDetails) {
        return empService.updateEmployee(id, empDetails);
    }

    // DELETE : DELETE /api/employees/{empId}
    @DeleteMapping("/employees/{empId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEmployee(@PathVariable("empId") Long id) {
        empService.deleteEmployee(id);
    }
}
