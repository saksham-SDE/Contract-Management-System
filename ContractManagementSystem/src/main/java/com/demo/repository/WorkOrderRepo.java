package com.demo.repository;

import com.demo.DTO.Contract;
import com.demo.DTO.WorkOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkOrderRepo extends JpaRepository<WorkOrder,Integer> {
}
