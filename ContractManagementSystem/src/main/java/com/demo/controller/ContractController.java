package com.demo.controller;

import com.demo.VO.ContractVo;
import com.demo.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contracts")
public class ContractController {

    @Autowired
    private ContractService service;

    @GetMapping
    public ResponseEntity<List<ContractVo>> getAllContracts() {
        return ResponseEntity.ok(service.getAllContractsVo());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContractVo> getContractById(@PathVariable int id) {
        ContractVo contractVo = service.getContractVoById(id);
        if (contractVo == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(contractVo);
    }

    @PostMapping
    public ResponseEntity<ContractVo> addContract(@RequestBody ContractVo contractVo) {
        return ResponseEntity.ok(service.addContractUserFriendly(contractVo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContractVo> updateContract(@PathVariable int id, @RequestBody ContractVo contractVo) {
        return ResponseEntity.ok(service.updateContractUserFriendly(id, contractVo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteContract(@PathVariable int id) {
        service.deleteContractById(id);
        return ResponseEntity.ok("Contract deleted successfully");
    }
}

