package com.demo.service;

import com.demo.DTO.Contract;
import com.demo.DTO.Employee;
import com.demo.DTO.Notification;
import com.demo.DTO.Contractor;
import com.demo.VO.ContractVo;
import com.demo.repository.ContractRepo;
import com.demo.repository.EmployeeRepo;
import com.demo.repository.NotificationRepo;
import com.demo.repository.ContractorRepo;
import com.demo.utility.ContractMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContractService {

    @Autowired
    private ContractRepo contractRepo;

    @Autowired
    private EmployeeRepo empRepo;

    @Autowired
    private NotificationRepo notiRepo;

    @Autowired
    private ContractorRepo contractorRepo;

    // Resolve employee name → ID
    private Integer getEmployeeIdByName(String name) {
        if (name == null || name.isEmpty()) return null;
        return empRepo.findAll().stream()
                .filter(emp -> emp.getName().equalsIgnoreCase(name))
                .map(Employee::getE_id)
                .findFirst()
                .orElse(null);
    }

    // Resolve notification title → ID
    private Integer getNotificationIdByTitle(String title) {
        if (title == null || title.isEmpty()) return null;
        return notiRepo.findAll().stream()
                .filter(not -> not.getN_title().equalsIgnoreCase(title))
                .map(Notification::getN_id)
                .findFirst()
                .orElse(null);
    }

    // Resolve contractor name → ID
    private Integer getContractorIdByName(String name) {
        if (name == null || name.isEmpty()) return null;
        return contractorRepo.findAll().stream()
                .filter(con -> con.getName().equalsIgnoreCase(name))
                .map(Contractor::getContractor_id)
                .findFirst()
                .orElse(null);
    }

    // Add contract (user-friendly)
    public ContractVo addContractUserFriendly(ContractVo contractVo) {
        Contract contract = new Contract();
        contract.setProject_name(contractVo.getProject_name());
        contract.setContract_start_date(contractVo.getContract_start_date());
        contract.setContract_end_date(contractVo.getContract_end_date());
        contract.setContract_cost(contractVo.getContract_cost());
        contract.setContract_status(contractVo.getContract_status());

        Integer eId = getEmployeeIdByName(contractVo.getEmployee_name());
        Integer nId = getNotificationIdByTitle(contractVo.getNotification_title());
        Integer contractorId = getContractorIdByName(contractVo.getContractor_name());

        if (eId == null || nId == null || contractorId == null)
            throw new RuntimeException("Employee, Notification, or Contractor not found");

        contract.setE_id(eId);
        contract.setN_id(nId);
        contract.setContractorId(contractorId);

        Contract saved = contractRepo.save(contract);

        Employee emp = empRepo.findById(saved.getE_id()).orElse(null);
        Notification not = notiRepo.findById(saved.getN_id()).orElse(null);
        Contractor contractor = contractorRepo.findById(saved.getContractorId()).orElse(null);

        return ContractMapper.mapContractToVo(saved, emp, not, contractor);
    }

    // Update contract (user-friendly)
    public ContractVo updateContractUserFriendly(int id, ContractVo contractVo) {
        return contractRepo.findById(id).map(contract -> {

            if (contractVo.getProject_name() != null) contract.setProject_name(contractVo.getProject_name());
            if (contractVo.getContract_start_date() != null) contract.setContract_start_date(contractVo.getContract_start_date());
            if (contractVo.getContract_end_date() != null) contract.setContract_end_date(contractVo.getContract_end_date());
            if (contractVo.getContract_cost() != null) contract.setContract_cost(contractVo.getContract_cost());
            if (contractVo.getContract_status() != null) contract.setContract_status(contractVo.getContract_status());

            if (contractVo.getEmployee_name() != null) {
                Integer eId = getEmployeeIdByName(contractVo.getEmployee_name());
                if (eId != null) contract.setE_id(eId);
            }

            if (contractVo.getNotification_title() != null) {
                Integer nId = getNotificationIdByTitle(contractVo.getNotification_title());
                if (nId != null) contract.setN_id(nId);
            }

            if (contractVo.getContractor_name() != null) {
                Integer contractorId = getContractorIdByName(contractVo.getContractor_name());
                if (contractorId != null) contract.setContractorId(contractorId);
            }

            Contract updated = contractRepo.save(contract);

            Employee emp = empRepo.findById(updated.getE_id()).orElse(null);
            Notification not = notiRepo.findById(updated.getN_id()).orElse(null);
            Contractor contractor = contractorRepo.findById(updated.getContractorId()).orElse(null);

            return ContractMapper.mapContractToVo(updated, emp, not, contractor);
        }).orElse(null);
    }

    // Get all contracts (VO)
    public List<ContractVo> getAllContractsVo() {
        return contractRepo.findAll().stream()
                .map(contract -> {
                    Employee emp = empRepo.findById(contract.getE_id()).orElse(null);
                    Notification not = notiRepo.findById(contract.getN_id()).orElse(null);
                    Contractor contractor = contractorRepo.findById(contract.getContractorId()).orElse(null);
                    return ContractMapper.mapContractToVo(contract, emp, not, contractor);
                })
                .collect(Collectors.toList());
    }

    // Get contract by ID (VO)
    public ContractVo getContractVoById(int id) {
        Contract contract = contractRepo.findById(id).orElse(null);
        if (contract == null) return null;

        Employee emp = empRepo.findById(contract.getE_id()).orElse(null);
        Notification not = notiRepo.findById(contract.getN_id()).orElse(null);
        Contractor contractor = contractorRepo.findById(contract.getContractorId()).orElse(null);

        return ContractMapper.mapContractToVo(contract, emp, not, contractor);
    }

    // Delete contract
    public void deleteContractById(int id) {
        contractRepo.deleteById(id);
    }
    public long getContractCount() {
        return contractRepo.count();
    }
    public List<ContractVo> getContractsByContractor(int contractorId) {
        return contractRepo.findByContractorId(contractorId)
                .stream()
                .map(contract -> {
                    Employee emp = empRepo.findById(contract.getE_id()).orElse(null);
                    Notification not = notiRepo.findById(contract.getN_id()).orElse(null);
                    Contractor contractor = contractorRepo.findById(contract.getContractorId()).orElse(null);
                    return ContractMapper.mapContractToVo(contract, emp, not, contractor);
                }).collect(Collectors.toList());
    }

}
