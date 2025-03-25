package com.demo.controller;

import com.demo.DTO.BillGenerator;
import com.demo.service.BillGeneratorService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@RestController
@RequestMapping("/api/bills")
public class BillGeneratorController {
    @Autowired
    private BillGeneratorService service;
    @Autowired
    private MessageSource messageSource;
    //Get Bills
    @GetMapping
    public List<BillGenerator> getAllBills(){
        return service.getAllBill();
    }
    //Get Bill
    @GetMapping("/{id}")
    public BillGenerator getBill(@PathVariable int id){
        return service.getBillById(id);
    }
    //Add Bill
    @PostMapping
    public ResponseEntity<?> addBill(@RequestBody BillGenerator billGenerator, @RequestHeader(name="Accept-Language",required = false)Locale locale){
        service.addBill(billGenerator);
        String message=messageSource.getMessage("bill.created",null,locale);
        Map<String, Object> response = new HashMap<>();
        response.put("message", message);
        response.put("bill", billGenerator);
        return ResponseEntity.ok(response);
    }
    //Delete Bill
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBill(@PathVariable int id,@RequestHeader(name = "Accept-Language", required = false) Locale locale){
        service.deleteBillById(id);
        String message = messageSource.getMessage("bill.deleted", null, locale);
        return ResponseEntity.ok(message);
    }
    //Update Bill Detail
    @PutMapping("/{id}")
    public ResponseEntity<?> updateBill(@PathVariable int id, @RequestBody BillGenerator updatedBill,@RequestHeader(name="Accept-Language",required = false)Locale locale) {
        BillGenerator bill =service.updateBillById(id, updatedBill);
        String message = messageSource.getMessage("bill.updated", null, locale);
        Map<String, Object> response = new HashMap<>();
        response.put("message", message);
        response.put("bill", bill);
        return ResponseEntity.ok(response);
    }
    @DeleteMapping("/list")
    public ResponseEntity<?> deleteBills(List<Integer> bills,@RequestHeader(name="Accept-Language",required = false)Locale locale){
        service.deleteBillsByIds(bills);
        String message=messageSource.getMessage("bill.deleted",null,locale);
        return ResponseEntity.ok(message);
    }

}
