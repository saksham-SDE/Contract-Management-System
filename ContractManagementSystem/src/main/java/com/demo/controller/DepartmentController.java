package com.demo.controller;

import com.demo.DTO.Department;
import com.demo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
    @Autowired
    private DepartmentService service;
    @Autowired
    private MessageSource messageSource;
    //Get Departments
    @GetMapping
    public List<Department> getAllDepartments(){
        return service.getAllDepartment();
    }
    //Get Department
    @GetMapping("/{id}")
    public Department getDepartment(@PathVariable int id){
        return service.getDepartmentById(id);
    }
    //Add New Department
    @PostMapping
    public ResponseEntity<?> addDepartment(@RequestBody Department department, @RequestHeader(name="Accept-Language",required = false) Locale locale){
        service.addDepartment(department);
        String message=messageSource.getMessage("department.created",null,locale);
        Map<String, Object> response = new HashMap<>();
        response.put("message", message);
        response.put("department", department);
        return ResponseEntity.ok(response);
    }
    //Delete Department
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable int id,@RequestHeader(name="Accept-Language",required = false)Locale locale){
        service.deleteDepartmentById(id);
        String message=messageSource.getMessage("department.deleted",null,locale);
        return ResponseEntity.ok(message);
    }
    //Update Department Details
    @PutMapping("/{id}")
    public ResponseEntity<?> updateDepartment(@PathVariable int id, @RequestBody Department department,@RequestHeader(name="Accept-Language",required = false)Locale locale){
        service.updateDepartmentById(id, department);
        String message=messageSource.getMessage("department.updated",null,locale);
        Map<String, Object> response = new HashMap<>();
        response.put("message", message);
        response.put("department", department);
        return ResponseEntity.ok(response);
    }
    @DeleteMapping("/list")
    public ResponseEntity<?> deleteDepartments(List<Integer> departments,@RequestHeader(name="Accept-Language",required = false)Locale locale){
        service.deleteDepartmentByIDs(departments);
        String message=messageSource.getMessage("department.deleted",null,locale);
        return ResponseEntity.ok(message);
    }
    @DeleteMapping("/soft-delete/{id}")
    public ResponseEntity<String> softDeleteDepartment(@PathVariable int id,@RequestHeader(name="Accept-Language",required = false)Locale locale){
        service.softDeleteDepartment(id);
        String message=messageSource.getMessage("department.deleted",null,locale);
        return ResponseEntity.ok(message);
    }
}


