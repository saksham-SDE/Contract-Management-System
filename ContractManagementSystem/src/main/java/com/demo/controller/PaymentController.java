package com.demo.controller;

import com.demo.DTO.Payment;
import com.demo.VO.PaymentVo;
import com.demo.service.PaymentService;
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
@RequestMapping("/api/payments")
public class PaymentController {
    @Autowired
    private PaymentService service;
    @Autowired
    private MessageSource messageSource;
    //Get Payments
    @GetMapping
    public List<PaymentVo> getAllPayments() {
        return service.getAllPayments();
    }

    @GetMapping("/{id}")
    public PaymentVo getPayment(@PathVariable int id) {
        return service.getPaymentById(id);
    }

    //Add New Payment
    @PostMapping
    public ResponseEntity<?> addPayment(@RequestBody Payment payment,@RequestHeader(name="Accept-Language",required = false) Locale locale){
       service.addPayment(payment);
       String message=messageSource.getMessage("payment.created",null,locale);
        Map<String, Object> response = new HashMap<>();
        response.put("message", message);
        response.put("payment", payment);
        return ResponseEntity.ok(response);
    }
    //Delete Payment
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePayment(@PathVariable int id,@RequestHeader(name="Accept-Language",required = false)Locale locale){
        service.deletePaymentById(id);
        String message=messageSource.getMessage("payment.deleted",null,locale);
        return ResponseEntity.ok(message);
    }
    //Update Payment Details
    @PutMapping("/{id}")
    public ResponseEntity<?> updatePayment(@PathVariable int id, @RequestBody Payment updatedPayment,@RequestHeader(name="Accept-Language",required = false)Locale locale) {
       service.updatePaymentById(id, updatedPayment);
       String message=messageSource.getMessage("payment.updated",null,locale);
        Map<String, Object> response = new HashMap<>();
        response.put("message", message);
        response.put("payment", updatedPayment);
        return ResponseEntity.ok(response);
    }
    @DeleteMapping("/list")
    public ResponseEntity<?> deletePayments(List<Integer> payments, @RequestHeader(name="Accept-Language",required = false)Locale locale){
        service.deletePaymentByIDs(payments);
        String message=messageSource.getMessage("payment.deleted",null,locale);
        return ResponseEntity.ok(message);
    }
    @GetMapping("/pending/count")
    public ResponseEntity<Long> getPendingPaymentsCount() {
        return ResponseEntity.ok(service.getPendingPaymentsCount());
    }

}
