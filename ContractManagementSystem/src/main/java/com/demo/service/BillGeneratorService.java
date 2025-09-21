package com.demo.service;

import com.demo.DTO.BillGenerator;
import com.demo.repository.BillGeneratorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BillGeneratorService {
    @Autowired
    private BillGeneratorRepo billGeneratorRepo;
    //Retrieve all bills from database
    public List<BillGenerator> getAllBill(){
        return billGeneratorRepo.findAll();
    }
    //Retrieve bill by its id from database
    public BillGenerator getBillById(int id){
        return billGeneratorRepo.findById(id).orElse(null);
    }
    //Add bill to the database
    public BillGenerator addBill(BillGenerator billGenerator){
        return billGeneratorRepo.save(billGenerator);
    }
    //Delete bill by its id from database
    public void deleteBillById(int id){
        billGeneratorRepo.deleteById(id);
    }
    //update bill details by its id in database
    public BillGenerator updateBillById(int id, BillGenerator updatedBill) {
        return billGeneratorRepo.findById(id)
                .map(bill -> {
                    if (updatedBill.getW_id() != 0) {
                        bill.setW_id(updatedBill.getW_id());
                    }
                    if (updatedBill.getContractor_id() != 0) {
                        bill.setContractor_id(updatedBill.getContractor_id());
                    }
                    if (updatedBill.getBill_amount() != null) {
                        bill.setBill_amount(updatedBill.getBill_amount());
                    }
                    if (updatedBill.getStatus() != null) {
                        bill.setStatus(updatedBill.getStatus());
                    }
                    if (updatedBill.getBill_date() != null) {
                        bill.setBill_date(updatedBill.getBill_date());
                    }
                    if (updatedBill.getFile_path_url() != null) {
                        bill.setFile_path_url(updatedBill.getFile_path_url());
                    }
                    return billGeneratorRepo.save(bill);
                }).orElse(null);
    }
    public void deleteBillsByIds(List<Integer> billIDs){
        billGeneratorRepo.deleteAllById(billIDs);
    }

}
