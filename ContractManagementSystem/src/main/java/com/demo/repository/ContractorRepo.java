package com.demo.repository;

import com.demo.DTO.Contractor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContractorRepo extends JpaRepository<Contractor,Integer> {
    List<Contractor> findByIsDeletedFalse(); // Fetch only non-deleted contracts
}
