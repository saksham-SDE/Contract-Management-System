package com.demo.service;

import com.demo.DTO.Contract;
import com.demo.repository.ContractRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ContractService {
    @Autowired
    private ContractRepo contractRepo;
    //Retrieves all contracts from database
    public List<Contract> getAllContract(){
        return contractRepo.findAll();
    }
    //Retrieve contract by id from database
    public Contract getContractById(int id){
        return contractRepo.findById(id).orElse(null);
    }
    //Add contract to the database
    public Contract addContract(Contract contract){
        return contractRepo.save(contract);
    }
    //Delete the contract by id from database
    public void deleteContractById(int id){
        contractRepo.deleteById(id);
    }
    //Update contract details by id in database
    public Contract updateContractById(int id, Contract updatedContract) {
        return contractRepo.findById(id)
                .map(contract -> {
                    if (updatedContract.getE_id() != 0) {
                        contract.setE_id(updatedContract.getE_id());
                    }
                    if (updatedContract.getN_id() != 0) {
                        contract.setN_id(updatedContract.getN_id());
                    }
                    if (updatedContract.getProject_name() != null) {
                        contract.setProject_name(updatedContract.getProject_name());
                    }
                    if (updatedContract.getContract_start_date() != null) {
                        contract.setContract_start_date(updatedContract.getContract_start_date());
                    }
                    if (updatedContract.getContract_end_date() != null) {
                        contract.setContract_end_date(updatedContract.getContract_end_date());
                    }
                    if (updatedContract.getContract_cost() != null) {
                        contract.setContract_cost(updatedContract.getContract_cost());
                    }
                    if (updatedContract.getContract_status() != null) {
                        contract.setContract_status(updatedContract.getContract_status());
                    }
                    if (updatedContract.getContractor_id() != 0) {
                        contract.setContractor_id(updatedContract.getContractor_id());
                    }
                    return contractRepo.save(contract);
                }).orElse(null);
    }
    public void deleteContractsByIds(List<Integer> contractsIDs){
        contractRepo.deleteAllById(contractsIDs);
    }
    public void softDeleteContract(int id) {
        Optional<Contract> contract = contractRepo.findById(id);
        if (contract.isPresent()) {
            Contract existingContract = contract.get();
            existingContract.setDeleted(true);
            existingContract.setDeletedAt(LocalDateTime.now());
            contractRepo.save(existingContract);
        } else {
            throw new RuntimeException("Contract not found");
        }
    }

}
