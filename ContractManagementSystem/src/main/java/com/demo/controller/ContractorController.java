package com.demo.controller;
import com.demo.DTO.Contractor;
import com.demo.service.ContractorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@RestController
@RequestMapping("/api/contractors")
public class ContractorController {
    @Autowired
    private ContractorService service;
    @Autowired
    private MessageSource messageSource;

    // Get All Contractors
    @GetMapping
    public ResponseEntity<List<Contractor>> getAllContractors() {
        return ResponseEntity.ok(service.getAllContractor());
    }

    // Get Contractor
    @GetMapping("/{id}")
    public ResponseEntity<Contractor> getContractor(@PathVariable int id) {
        return ResponseEntity.of(service.getContractorById(id));
    }

    // Add Contractor
    @PostMapping
    public ResponseEntity<?> addContractor(@RequestBody Contractor contractor, @RequestHeader(name="Accept-Language",required = false)Locale locale) {
        service.addContractor(contractor);
        String message=messageSource.getMessage("contractor.created",null,locale);
        Map<String, Object> response = new HashMap<>();
        response.put("message", message);
        response.put("contractor", contractor);
        return ResponseEntity.ok(response);
    }

    // Delete Contractor
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteContractor(@PathVariable int id,@RequestHeader(name = "Accept-Language",required = false)Locale locale) {
        service.deleteContractorById(id);
        String message=messageSource.getMessage("contractor.deleted",null,locale);
        return ResponseEntity.ok(message);
    }

    // Update Contractor Details
    @PutMapping("/{id}")
    public ResponseEntity<?> updateContractor(@PathVariable int id, @RequestBody Contractor contractor,@RequestHeader(name="Accept-Language",required = false)Locale locale) {
        service.updateContractor(id, contractor);
        String message=messageSource.getMessage("contractor.updated",null,locale);
        Map<String, Object> response = new HashMap<>();
        response.put("message", message);
        response.put("contractor", contractor);
        return ResponseEntity.ok(response);
    }
    @DeleteMapping("/list")
    public ResponseEntity<?> deleteContractors(List<Integer> contractors,@RequestHeader(name="Accept-Language",required = false)Locale locale){
        service.deleteContractorByIDs(contractors);
        String message= messageSource.getMessage("contractor.deleted",null,locale);
        return ResponseEntity.ok(message);
    }
    @DeleteMapping("/soft-delete/{id}")
    public ResponseEntity<String> softDeleteContractor(@PathVariable int id, @RequestHeader(name="Accept-Language",required = false)Locale locale){
        service.softDeleteContractor(id);
        String message=messageSource.getMessage("contractor.deleted",null,locale);
        return ResponseEntity.ok(message);
    }
}
