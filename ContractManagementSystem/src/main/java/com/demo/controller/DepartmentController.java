package com.demo.controller;

import com.demo.VO.DepartmentVo;
import com.demo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService service;

    // Get all
    @GetMapping
    public ResponseEntity<List<DepartmentVo>> getAllDepartments() {
        return ResponseEntity.ok(service.getAllDepartmentsVo());
    }

    // Get by ID
    @GetMapping("/{id}")
    public ResponseEntity<DepartmentVo> getDepartment(@PathVariable int id) {
        DepartmentVo vo = service.getDepartmentVoById(id);
        return vo != null ? ResponseEntity.ok(vo) : ResponseEntity.notFound().build();
    }

    // Add
    @PostMapping
    public ResponseEntity<DepartmentVo> addDepartment(@RequestBody DepartmentVo vo) {
        DepartmentVo created = service.addDepartmentVo(vo);
        return ResponseEntity.ok(created);
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<DepartmentVo> updateDepartment(@PathVariable int id, @RequestBody DepartmentVo vo) {
        DepartmentVo updated = service.updateDepartmentVo(id, vo);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDepartment(@PathVariable int id) {
        service.deleteDepartmentById(id);
        return ResponseEntity.noContent().build();
    }

    // Delete multiple
    @DeleteMapping("/list")
    public ResponseEntity<Void> deleteDepartments(@RequestBody List<Integer> ids) {
        service.deleteDepartmentsByIds(ids);
        return ResponseEntity.noContent().build();
    }
}
