package com.demo.controller;

import com.demo.DTO.Employee;
import com.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService service;
    @Autowired
    private MessageSource messageSource;
    //Get Employees
    @GetMapping
    public List<Employee> getAllEmployees(){
        return service.getAllEmployee();
    }
    //Get Employee
    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable int id){
        return service.getEmployeeById(id);
    }
    //Add Employee
    @PostMapping
    public ResponseEntity<?> addEmployee(@RequestBody Employee employee, @RequestHeader(name="Accept-Language",required = false)Locale locale){
        service.addEmployee(employee);
        String message=messageSource.getMessage("employee.created",null,locale);
        Map<String, Object> response = new HashMap<>();
        response.put("message", message);
        response.put("employee", employee);
        return ResponseEntity.ok(response);
    }
    //Delete Employee
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable int id,@RequestHeader(name="Accept-Language",required = false)Locale locale){
        service.deleteEmployeeById(id);
        String message=messageSource.getMessage("employee.deleted",null,locale);
        return ResponseEntity.ok(message);
    }
    //Update Employee Details
    @PutMapping("/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable int id, @RequestBody Employee updatedEmployee,@RequestHeader(name="Accept-Language",required = false)Locale locale) {
        service.updateEmployeeById(id, updatedEmployee);
        String message=messageSource.getMessage("employee.updated",null,locale);
        Map<String, Object> response = new HashMap<>();
        response.put("message", message);
        response.put("employee", updatedEmployee);
        return ResponseEntity.ok(response);

    }
    @DeleteMapping("/list")
    public ResponseEntity<?> deleteEmployees(List<Integer> employees,@RequestHeader(name="Accept-Language",required = false)Locale locale){
        service.deleteEmployeesByIDs(employees);
        String message= messageSource.getMessage("employee.deleted",null,locale);
        return ResponseEntity.ok(message);
    }

}


