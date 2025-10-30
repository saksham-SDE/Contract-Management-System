package com.demo.repository;

import com.demo.DTO.WorkOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface WorkOrderRepo extends JpaRepository<WorkOrder, Integer> {
    List<WorkOrder> findByContractorId(Integer contractorId);
}
