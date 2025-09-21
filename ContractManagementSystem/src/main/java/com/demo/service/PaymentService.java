package com.demo.service;

import com.demo.DTO.Payment;
import com.demo.repository.PaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepo paymentRepo;
    //Retrieves all payments from the database
    public List<Payment> getAllPayment(){
        return paymentRepo.findAll();
    }
    //Retrieve payment by id from the database
    public Payment getPaymentById(int id){
        return paymentRepo.findById(id).orElse(null);
    }
    //Add payment to the database
    public Payment addPayment(Payment payment){
        return paymentRepo.save(payment);
    }
    //Delete payment by id from the database
    public void deletePaymentById(int id){
        paymentRepo.deleteById(id);
    }
    //Update payment details by id from the database
    public Payment updatePaymentById(int id, Payment updatedPayment) {
        return paymentRepo.findById(id)
                .map(payment -> {
                    if (updatedPayment.getC_id() != 0) {
                        payment.setC_id(updatedPayment.getC_id());
                    }
                    if (updatedPayment.getBill_id() != 0) {
                        payment.setBill_id(updatedPayment.getBill_id());
                    }
                    if (updatedPayment.getAmount() != null) {
                        payment.setAmount(updatedPayment.getAmount());
                    }
                    if (updatedPayment.getP_status() != null) {
                        payment.setP_status(updatedPayment.getP_status());
                    }
                    if (updatedPayment.getP_time() != null) {
                        payment.setP_time(updatedPayment.getP_time());
                    }
                    return paymentRepo.save(payment);
                }).orElse(null);
    }
    public void deletePaymentByIDs(List<Integer> paymentIDs){
        paymentRepo.deleteAllById(paymentIDs);
    }



}
