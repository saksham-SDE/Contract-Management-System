package com.demo.controller;
import com.demo.DTO.WorkOrder;
import com.demo.service.WorkOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@RestController
@RequestMapping("/api/workorders")
public class WorkOrderController {
    @Autowired
    private WorkOrderService service;
    @Autowired
    private MessageSource messageSource;
    //Get Work-orders
    @GetMapping
    public List<WorkOrder> getAllWorkOrders(){
        return service.getAllWorkOrder();
    }
    //Get Work-order
    @GetMapping("/{id}")
    public WorkOrder getWorkOrderById(@PathVariable int id){
        return service.getWorkOrderById(id);
    }
    //Add Work-order
    @PostMapping
    public ResponseEntity<?> addWorkOrder(@RequestBody WorkOrder workOrder, @RequestHeader(name="Accept-Language",required = false)Locale locale){
        service.addWorkOrder(workOrder);
        String message=messageSource.getMessage("workorder.created",null,locale);
        Map<String, Object> response = new HashMap<>();
        response.put("message", message);
        response.put("workorder", workOrder);
        return ResponseEntity.ok(response);
    }
    //Delete Work-order
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteWorkOrderById(@PathVariable int id,@RequestHeader(name="Accept-Language",required = false)Locale locale){
        service.deleteWorkOrderById(id);
        String message=messageSource.getMessage("workorder.deleted",null,locale);
        return ResponseEntity.ok(message);
    }
    //Update Work-order Details
    @PutMapping("/{id}")
    public ResponseEntity<?> updateWorkOrder(@PathVariable int id, @RequestBody WorkOrder updatedWorkOrder,@RequestHeader(name="Accept-Language",required = false)Locale locale) {
        service.updateWorkOrderById(id, updatedWorkOrder);
        String message=messageSource.getMessage("workorder.updated",null,locale);
        Map<String, Object> response = new HashMap<>();
        response.put("message", message);
        response.put("workorder", updatedWorkOrder);
        return ResponseEntity.ok(response);
    }
    public ResponseEntity<?> deleteWorkOrders(List<Integer> workorders,@RequestHeader(name="Accept-Language",required = false)Locale locale){
        service.deleteWorkOrderByIDs(workorders);
        String message=messageSource.getMessage("workorder.deleted",null,locale);
        return ResponseEntity.ok(message);
    }
    @DeleteMapping("/soft-delete/{id}")
    public ResponseEntity<String> softDeleteWorkOrder(@PathVariable int id,@RequestHeader(name="Accept-Language",required = false)Locale locale){
        service.softDeleteWorkOrder(id);
        String message=messageSource.getMessage("workorder.deleted",null,locale);
        return ResponseEntity.ok(message);
    }

}
