package com.demo.repository;

import com.demo.DTO.Contract;
import com.demo.DTO.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepo extends JpaRepository<Payment,Integer> {

}
