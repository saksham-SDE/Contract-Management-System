package com.demo.controller;

import com.demo.VO.ContractorVo;
import com.demo.service.ContractorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contractors")
public class ContractorController {

    @Autowired
    private ContractorService service;

    // Get all contractors
    @GetMapping
    public ResponseEntity<List<ContractorVo>> getAllContractors() {
        return ResponseEntity.ok(service.getAllContractorsVo());
    }

    // Get contractor by ID
    @GetMapping("/{id}")
    public ResponseEntity<ContractorVo> getContractor(@PathVariable int id) {
        ContractorVo contractor = service.getContractorVoById(id);
        return contractor != null ? ResponseEntity.ok(contractor) : ResponseEntity.notFound().build();
    }

    // Add contractor
    @PostMapping
    public ResponseEntity<ContractorVo> addContractor(@RequestBody ContractorVo contractorVo) {
        return ResponseEntity.ok(service.addContractorUserFriendly(contractorVo));
    }

    // Update contractor
    @PutMapping("/{id}")
    public ResponseEntity<ContractorVo> updateContractor(@PathVariable int id, @RequestBody ContractorVo contractorVo) {
        ContractorVo updated = service.updateContractorUserFriendly(id, contractorVo);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    // Delete contractor
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContractor(@PathVariable int id) {
        service.deleteContractorById(id);
        return ResponseEntity.noContent().build();
    }
}
