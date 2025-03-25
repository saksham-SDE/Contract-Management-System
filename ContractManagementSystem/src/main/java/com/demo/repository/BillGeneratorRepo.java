package com.demo.repository;

import com.demo.DTO.BillGenerator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillGeneratorRepo extends JpaRepository<BillGenerator,Integer> {
}
