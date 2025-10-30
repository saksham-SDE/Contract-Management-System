package com.demo.service;

import com.demo.DTO.WorkOrder;
import com.demo.DTO.Contract;
import com.demo.DTO.Contractor;
import com.demo.VO.WorkOrderVo;
import com.demo.repository.WorkOrderRepo;
import com.demo.repository.ContractRepo;
import com.demo.repository.ContractorRepo;
import com.demo.utility.WorkOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WorkOrderService {

    @Autowired
    private WorkOrderRepo workOrderRepo;

    @Autowired
    private ContractRepo contractRepo;

    @Autowired
    private ContractorRepo contractorRepo;

    private Integer getContractIdByName(String name) {
        if (name == null || name.isEmpty()) return null;
        return contractRepo.findAll().stream()
                .filter(c -> c.getProject_name() != null && c.getProject_name().equalsIgnoreCase(name))
                .map(Contract::getC_id)
                .findFirst()
                .orElse(null);
    }

    private Integer getContractorIdByName(String name) {
        if (name == null || name.isEmpty()) return null;
        return contractorRepo.findAll().stream()
                .filter(c -> c.getName() != null && c.getName().equalsIgnoreCase(name))
                .map(Contractor::getContractor_id)
                .findFirst()
                .orElse(null);
    }

    public WorkOrderVo addWorkOrderUserFriendly(WorkOrderVo vo) {
        WorkOrder w = new WorkOrder();
        w.setWIssuedDate(vo.getW_issued_date());
        w.setWStatus(vo.getW_status());
        w.setWCost(vo.getW_cost());

        Integer cId = getContractIdByName(vo.getProject_name());
        Integer contractorId = getContractorIdByName(vo.getContractor_name());

        if (cId == null || contractorId == null) {
            throw new RuntimeException("Contract or Contractor not found");
        }

        w.setCId(cId);
        w.setContractorId(contractorId);

        WorkOrder saved = workOrderRepo.save(w);

        Contract contract = contractRepo.findById(saved.getCId()).orElse(null);
        Contractor contractor = contractorRepo.findById(saved.getContractorId()).orElse(null);

        return WorkOrderMapper.mapWorkOrderToVo(saved, contract, contractor);
    }

    public WorkOrderVo updateWorkOrderUserFriendly(int id, WorkOrderVo vo) {
        return workOrderRepo.findById(id).map(w -> {
            if (vo.getW_issued_date() != null) w.setWIssuedDate(vo.getW_issued_date());
            if (vo.getW_status() != null) w.setWStatus(vo.getW_status());
            if (vo.getW_cost() != null) w.setWCost(vo.getW_cost());

            if (vo.getProject_name() != null) {
                Integer cId = getContractIdByName(vo.getProject_name());
                if (cId != null) w.setCId(cId);
            }

            if (vo.getContractor_name() != null) {
                Integer contractorId = getContractorIdByName(vo.getContractor_name());
                if (contractorId != null) w.setContractorId(contractorId);
            }

            WorkOrder updated = workOrderRepo.save(w);
            Contract contract = contractRepo.findById(updated.getCId()).orElse(null);
            Contractor contractor = contractorRepo.findById(updated.getContractorId()).orElse(null);

            return WorkOrderMapper.mapWorkOrderToVo(updated, contract, contractor);
        }).orElse(null);
    }

    public List<WorkOrderVo> getAllWorkOrdersVo() {
        return workOrderRepo.findAll().stream()
                .map(w -> {
                    Contract contract = contractRepo.findById(w.getCId()).orElse(null);
                    Contractor contractor = contractorRepo.findById(w.getContractorId()).orElse(null);
                    return WorkOrderMapper.mapWorkOrderToVo(w, contract, contractor);
                })
                .collect(Collectors.toList());
    }

    public WorkOrderVo getWorkOrderVoById(int id) {
        WorkOrder w = workOrderRepo.findById(id).orElse(null);
        if (w == null) return null;
        Contract contract = contractRepo.findById(w.getCId()).orElse(null);
        Contractor contractor = contractorRepo.findById(w.getContractorId()).orElse(null);
        return WorkOrderMapper.mapWorkOrderToVo(w, contract, contractor);
    }

    public void deleteWorkOrderById(int id) {
        workOrderRepo.deleteById(id);
    }

    public List<WorkOrderVo> getWorkOrdersForContractor(int contractorId) {
        return workOrderRepo.findByContractorId(contractorId).stream()
                .map(w -> {
                    Contract contract = contractRepo.findById(w.getCId()).orElse(null);
                    Contractor contractor = contractorRepo.findById(w.getContractorId()).orElse(null);
                    return WorkOrderMapper.mapWorkOrderToVo(w, contract, contractor);
                })
                .collect(Collectors.toList());
    }
    public long getWorkOrderCount() {
        return workOrderRepo.count();
    }

}
