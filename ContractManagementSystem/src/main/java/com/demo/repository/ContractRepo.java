package com.demo.repository;

import com.demo.DTO.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContractRepo extends JpaRepository<Contract,Integer> {

}
