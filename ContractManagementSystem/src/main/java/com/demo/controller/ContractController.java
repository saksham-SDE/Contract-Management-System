package com.demo.controller;
import com.demo.DTO.Contract;
import com.demo.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@RestController
@RequestMapping("/api/contracts")
public class ContractController {
    @Autowired
    private ContractService service;
    @Autowired
    private MessageSource messageSource;
    //Get Contracts
    @GetMapping
    public List<Contract> getAllContracts(){
        return service.getAllContract();
    }
    //Get Contract
    @GetMapping("/{id}")
    public Contract getContract(@PathVariable int id){
        return service.getContractById(id);
    }
    //Add Contract
    @PostMapping
    public ResponseEntity<?> addContract(@RequestBody Contract contract, @RequestHeader(name = "Accept-Language",required = false)Locale locale){
        service.addContract(contract);
        String message=messageSource.getMessage("contract.created",null,locale);
        Map<String, Object> response = new HashMap<>();
        response.put("message", message);
        response.put("contract",contract);
        return ResponseEntity.ok(response);

    }
    //Delete Contract
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteContract(@PathVariable int id,@RequestHeader(name = "Accept-language",required = false)Locale locale){
        service.deleteContractById(id);
        String message=messageSource.getMessage("contract.deleted",null,locale);
        return ResponseEntity.ok(message);
    }
    //Update Contract
    @PutMapping("/{id}")
    public ResponseEntity<?> updateContract(@PathVariable int id, @RequestBody Contract updatedContract,@RequestHeader(name = "Accept-Language",required = false)Locale locale) {
        Contract contract = service.updateContractById(id, updatedContract);
        String message=messageSource.getMessage("contract.updated",null,locale);
        Map<String, Object> response = new HashMap<>();
        response.put("message", message);
        response.put("contract", contract);
        return ResponseEntity.ok(response);
    }
    @DeleteMapping("/list")
    public ResponseEntity<String> deleteContracts(@RequestBody List<Integer> contracts,@RequestHeader(name="Accept-Language",required = false)Locale locale){
        service.deleteContractsByIds(contracts);
        String message=messageSource.getMessage("contract.deleted",null,locale);
        return ResponseEntity.ok(message);
    }

}
