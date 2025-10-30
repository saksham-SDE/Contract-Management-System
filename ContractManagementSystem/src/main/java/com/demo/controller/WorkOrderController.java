package com.demo.controller;

import com.demo.DTO.securityModel.User;
import com.demo.VO.WorkOrderVo;
import com.demo.repository.securityRepository.UserRepo;
import com.demo.service.WorkOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/workorders")
public class WorkOrderController {

    @Autowired
    private WorkOrderService service;

    @Autowired
    private UserRepo userRepo;

    @GetMapping
    public ResponseEntity<List<WorkOrderVo>> getAll() {
        // Get currently logged-in username from SecurityContext
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepo.findByUsername(username);

        if (user == null) {
            return ResponseEntity.status(403).build();
        }

        String role = user.getRole().toUpperCase();
        List<WorkOrderVo> result;

        switch (role) {
            case "CONTRACTOR":
                if (user.getContractorId() != null) {
                    result = service.getWorkOrdersForContractor(user.getContractorId());
                } else {
                    // Contractor without linked ID gets empty list
                    result = List.of();
                }
                break;

            case "ADMIN":
            case "EMPLOYEE":
                // Admins and employees see everything
                result = service.getAllWorkOrdersVo();
                break;

            default:
                // Other roles (if any) have no access
                return ResponseEntity.status(403).build();
        }

        return ResponseEntity.ok(result);
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
    @GetMapping("/count")
    public ResponseEntity<Long> getWorkOrderCount() {
        return ResponseEntity.ok(service.getWorkOrderCount());
    }

}
