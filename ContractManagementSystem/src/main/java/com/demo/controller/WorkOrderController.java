package com.demo.controller;

import com.demo.VO.WorkOrderVo;
import com.demo.service.WorkOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/workorders")
public class WorkOrderController {

    @Autowired
    private WorkOrderService service;

    @GetMapping
    public ResponseEntity<List<WorkOrderVo>> getAll() {
        return ResponseEntity.ok(service.getAllWorkOrdersVo());
    }

    @GetMapping("/{id}")
    public ResponseEntity<WorkOrderVo> getById(@PathVariable int id) {
        WorkOrderVo vo = service.getWorkOrderVoById(id);
        if (vo == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(vo);
    }

    @PostMapping
    public ResponseEntity<WorkOrderVo> add(@RequestBody WorkOrderVo vo) {
        return ResponseEntity.ok(service.addWorkOrderUserFriendly(vo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<WorkOrderVo> update(@PathVariable int id, @RequestBody WorkOrderVo vo) {
        return ResponseEntity.ok(service.updateWorkOrderUserFriendly(id, vo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        service.deleteWorkOrderById(id);
        return ResponseEntity.ok("Work order deleted successfully");
    }
}
