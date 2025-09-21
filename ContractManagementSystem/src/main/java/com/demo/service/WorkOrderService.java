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

    // resolve contract id by project name
    private Integer getContractIdByName(String name) {
        if (name == null || name.isEmpty()) return null;
        return contractRepo.findAll().stream()
                .filter(c -> c.getProject_name() != null && c.getProject_name().equalsIgnoreCase(name))
                .map(Contract::getC_id)
                .findFirst()
                .orElse(null);
    }

    // resolve contractor id by name
    private Integer getContractorIdByName(String name) {
        if (name == null || name.isEmpty()) return null;
        return contractorRepo.findAll().stream()
                .filter(c -> c.getName() != null && c.getName().equalsIgnoreCase(name))
                .map(Contractor::getContractor_id)
                .findFirst()
                .orElse(null);
    }

    // Add work order using human-friendly VO
    public WorkOrderVo addWorkOrderUserFriendly(WorkOrderVo vo) {
        WorkOrder w = new WorkOrder();
        w.setW_issued_date(vo.getW_issued_date());
        w.setW_status(vo.getW_status());
        w.setW_cost(vo.getW_cost());

        Integer cId = getContractIdByName(vo.getContract_name());
        Integer contractorId = getContractorIdByName(vo.getContractor_name());

        if (cId == null || contractorId == null) {
            throw new RuntimeException("Contract or Contractor not found");
        }

        w.setC_id(cId);
        w.setContractor_id(contractorId);

        WorkOrder saved = workOrderRepo.save(w);

        Contract contract = contractRepo.findById(saved.getC_id()).orElse(null);
        Contractor contractor = contractorRepo.findById(saved.getContractor_id()).orElse(null);

        return WorkOrderMapper.mapWorkOrderToVo(saved, contract, contractor);
    }

    // Update user-friendly
    public WorkOrderVo updateWorkOrderUserFriendly(int id, WorkOrderVo vo) {
        return workOrderRepo.findById(id).map(w -> {
            if (vo.getW_issued_date() != null) w.setW_issued_date(vo.getW_issued_date());
            if (vo.getW_status() != null) w.setW_status(vo.getW_status());
            if (vo.getW_cost() != null) w.setW_cost(vo.getW_cost());

            if (vo.getContract_name() != null) {
                Integer cId = getContractIdByName(vo.getContract_name());
                if (cId != null) w.setC_id(cId);
            }

            if (vo.getContractor_name() != null) {
                Integer contractorId = getContractorIdByName(vo.getContractor_name());
                if (contractorId != null) w.setContractor_id(contractorId);
            }

            WorkOrder updated = workOrderRepo.save(w);
            Contract contract = contractRepo.findById(updated.getC_id()).orElse(null);
            Contractor contractor = contractorRepo.findById(updated.getContractor_id()).orElse(null);

            return WorkOrderMapper.mapWorkOrderToVo(updated, contract, contractor);
        }).orElse(null);
    }

    // Get all VO
    public List<WorkOrderVo> getAllWorkOrdersVo() {
        return workOrderRepo.findAll().stream()
                .map(w -> {
                    Contract contract = contractRepo.findById(w.getC_id()).orElse(null);
                    Contractor contractor = contractorRepo.findById(w.getContractor_id()).orElse(null);
                    return WorkOrderMapper.mapWorkOrderToVo(w, contract, contractor);
                })
                .collect(Collectors.toList());
    }

    // Get by id VO
    public WorkOrderVo getWorkOrderVoById(int id) {
        WorkOrder w = workOrderRepo.findById(id).orElse(null);
        if (w == null) return null;
        Contract contract = contractRepo.findById(w.getC_id()).orElse(null);
        Contractor contractor = contractorRepo.findById(w.getContractor_id()).orElse(null);
        return WorkOrderMapper.mapWorkOrderToVo(w, contract, contractor);
    }

    // Raw delete
    public void deleteWorkOrderById(int id) {
        workOrderRepo.deleteById(id);
    }
}
