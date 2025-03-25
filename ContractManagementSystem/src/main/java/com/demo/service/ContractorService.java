package com.demo.service;

import com.demo.DTO.Contractor;
import com.demo.repository.ContractorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ContractorService {
    @Autowired
    private ContractorRepo contractorRepo;
    //Retrieve all contractors from database
    public List<Contractor> getAllContractor(){
        return contractorRepo.findAll();
    }
    //Retrieve contractor by its id from database
    public Optional<Contractor> getContractorById(int id){
        return contractorRepo.findById(id);
    }
    //Add contractor to the database
    public Contractor addContractor(Contractor contractor) {
        if (contractorRepo.existsById(contractor.getContractor_id())) {
            return null; // Contractor already exists
        }
        return contractorRepo.save(contractor); // Save new contractor
    }
    //Delete contractor by its id from database
    public boolean deleteContractorById(int id){
        if(contractorRepo.existsById(id)){
        contractorRepo.deleteById(id);
        return true;
        }
        return false;
    }
    //Update contractor details by its id in database
    public Optional<Contractor> updateContractor(int id, Contractor updateContractor){
        return contractorRepo.findById(id)
                .map(contractor -> {
                    if(updateContractor.getName()!=null){
                        contractor.setName(updateContractor.getName());
                    }
                    if(updateContractor.getAddress()!=null){
                        contractor.setAddress(updateContractor.getAddress());
                    }
                    if(updateContractor.getEmail()!=null){
                        contractor.setEmail(updateContractor.getEmail());
                    }
                    if(updateContractor.getContact_no()!=null){
                        contractor.setContact_no(updateContractor.getContact_no());
                    }
                    if(updateContractor.getLicense_no()!=null){
                        contractor.setLicense_no(updateContractor.getLicense_no());
                    }
                    if(updateContractor.getRegister_date()!=null){
                        contractor.setRegister_date(updateContractor.getRegister_date());
                    }
                    return contractorRepo.save(contractor);
                });
    }
    public void deleteContractorByIDs(List<Integer> contractorIDs){
        contractorRepo.deleteAllById(contractorIDs);
    }
    public void softDeleteContractor(int id){
        Optional<Contractor> contractor=contractorRepo.findById(id);
        if(contractor.isPresent()){
            Contractor existingContractor=contractor.get();
            existingContractor.setDeleted(true);
            existingContractor.setDeletedAt(LocalDateTime.now());
            contractorRepo.save(existingContractor);
        }
        else{
            throw new RuntimeException("Contractor Not Found");
        }
    }

}
