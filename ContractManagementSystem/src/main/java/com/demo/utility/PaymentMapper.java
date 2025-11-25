package com.demo.utility;

import com.demo.DTO.Payment;
import com.demo.VO.PaymentVo;
import com.demo.DTO.Contract;
import com.demo.DTO.Contractor;
import com.demo.repository.ContractRepo;
import com.demo.repository.ContractorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentMapper {

    @Autowired
    private ContractRepo contractRepo;

    @Autowired
    private ContractorRepo contractorRepo;

    public PaymentVo convertToVO(Payment payment) {

        PaymentVo vo = new PaymentVo();

        vo.setPaymentId(payment.getPayment_id());
        vo.setAmount(payment.getAmount());
        vo.setBillId(payment.getBill_id());
        vo.setStatus(payment.getStatus());
        vo.setPaymentTime(payment.getP_time());

        // Fetch Contract
        Contract contract = contractRepo.findById(payment.getC_id()).orElse(null);

        if (contract != null) {
            vo.setContractName(contract.getProject_name());
        } else {
            vo.setContractName("Unknown Contract");
        }

        // --- FIXED CONTRACTOR CHECK ---
        int contractorId = (contract != null) ? contract.getContractorId() : 0;

        if (contractorId != 0) {
            Contractor contractor = contractorRepo.findById(contractorId).orElse(null);

            if (contractor != null) {
                vo.setContractorName(contractor.getName());
            } else {
                vo.setContractorName("Unknown Contractor");
            }

        } else {
            vo.setContractorName("Unknown Contractor");
        }

        return vo;
    }
}
