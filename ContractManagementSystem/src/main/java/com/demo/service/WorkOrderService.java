package com.demo.service;

import com.demo.DTO.WorkOrder;
import com.demo.repository.WorkOrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class WorkOrderService {
    @Autowired
    private WorkOrderRepo workOrderRepo;
    //Retrieves all workorders from the database
    public List<WorkOrder> getAllWorkOrder(){
        return workOrderRepo.findAll();
    }
    //Retrieve workorder by id from the database
    public WorkOrder getWorkOrderById(int id){
        return workOrderRepo.findById(id).orElse(null);
    }
    //Add new workorder to the database
    public WorkOrder addWorkOrder(WorkOrder workOrder){
        return workOrderRepo.save(workOrder);
    }
    //Delete workorder by id from the database
    public void deleteWorkOrderById(int id){
        workOrderRepo.deleteById(id);
    }
    //Update workorder details by id in the database
    public WorkOrder updateWorkOrderById(int id, WorkOrder updatedWorkOrder) {
        return workOrderRepo.findById(id)
                .map(workOrder -> {
                    if (updatedWorkOrder.getW_issued_date() != null) {
                        workOrder.setW_issued_date(updatedWorkOrder.getW_issued_date());
                    }
                    if (updatedWorkOrder.getW_status() != null) {
                        workOrder.setW_status(updatedWorkOrder.getW_status());
                    }
                    if (updatedWorkOrder.getW_cost() != null) {
                        workOrder.setW_cost(updatedWorkOrder.getW_cost());
                    }
                    if (updatedWorkOrder.getContractor_id() != 0) {
                        workOrder.setContractor_id(updatedWorkOrder.getContractor_id());
                    }
                    if (updatedWorkOrder.getC_id() != 0) {
                        workOrder.setC_id(updatedWorkOrder.getC_id());
                    }
                    return workOrderRepo.save(workOrder);
                }).orElse(null);
    }
    public void deleteWorkOrderByIDs(List<Integer> workorderIDs){
        workOrderRepo.deleteAllById(workorderIDs);
    }
    public void softDeleteWorkOrder(int id){
        Optional<WorkOrder> workOrder=workOrderRepo.findById(id);
        if(workOrder.isPresent()){
            WorkOrder existingWorkOrder=workOrder.get();
            existingWorkOrder.setDeleted(true);
            existingWorkOrder.setDeletedAt(LocalDateTime.now());
            workOrderRepo.save(existingWorkOrder);
        }
        else {
            throw new RuntimeException("Work-Order Not Found");
        }
    }
}
