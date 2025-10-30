package com.demo.service;

import com.demo.DTO.Contractor;
import com.demo.VO.ContractorVo;
import com.demo.repository.ContractorRepo;
import com.demo.utility.ContractorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContractorService {

    @Autowired
    private ContractorRepo contractorRepo;

    // Add contractor (user-friendly)
    public ContractorVo addContractorUserFriendly(ContractorVo contractorVo) {
        Contractor contractor = ContractorMapper.mapToEntity(contractorVo);
        Contractor saved = contractorRepo.save(contractor);
        return ContractorMapper.mapToVo(saved);
    }

    // Update contractor (user-friendly)
    public ContractorVo updateContractorUserFriendly(int id, ContractorVo contractorVo) {
        return contractorRepo.findById(id).map(existing -> {
            if (contractorVo.getName() != null) existing.setName(contractorVo.getName());
            if (contractorVo.getEmail() != null) existing.setEmail(contractorVo.getEmail());
            if (contractorVo.getContact_no() != null) existing.setContact_no(contractorVo.getContact_no());
            if (contractorVo.getAddress() != null) existing.setAddress(contractorVo.getAddress());
            if (contractorVo.getLicense_no() != null) existing.setLicense_no(contractorVo.getLicense_no());
            if (contractorVo.getRegister_date() != null) existing.setRegister_date(contractorVo.getRegister_date());

            Contractor updated = contractorRepo.save(existing);
            return ContractorMapper.mapToVo(updated);
        }).orElse(null);
    }

    // Get all contractors (VO)
    public List<ContractorVo> getAllContractorsVo() {
        return contractorRepo.findAll().stream()
                .map(ContractorMapper::mapToVo)
                .collect(Collectors.toList());
    }

    // Get contractor by ID (VO)
    public ContractorVo getContractorVoById(int id) {
        return contractorRepo.findById(id)
                .map(ContractorMapper::mapToVo)
                .orElse(null);
    }

    // Delete contractor
    public void deleteContractorById(int id) {
        contractorRepo.deleteById(id);
    }
    public long getContractorCount() {
        return contractorRepo.count();
    }

}
