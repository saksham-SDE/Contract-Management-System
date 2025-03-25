package com.demo.repository;

import com.demo.DTO.BillGenerator;
import com.demo.DTO.Contract;
import com.demo.DTO.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.*;
import java.util.List;

@Repository
public interface DepartmentRepo extends JpaRepository<Department,Integer> {
    List<Department> findByIsDeletedFalse(); // Fetch only non-deleted contracts
}
