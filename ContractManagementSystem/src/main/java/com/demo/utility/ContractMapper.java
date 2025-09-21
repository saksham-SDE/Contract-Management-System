package com.demo.utility;

import com.demo.DTO.Contract;
import com.demo.DTO.Employee;
import com.demo.DTO.Notification;
import com.demo.DTO.Contractor;
import com.demo.VO.ContractVo;

public class ContractMapper {

    public static ContractVo mapContractToVo(Contract contract, Employee emp, Notification not, Contractor contractor) {
        return new ContractVo(
                contract.getC_id(),
                contract.getProject_name(),
                contract.getContract_start_date(),
                contract.getContract_end_date(),
                contract.getContract_cost(),
                contract.getContract_status(),
                emp != null ? emp.getName() : null,
                not != null ? not.getN_title() : null,
                contractor != null ? contractor.getName() : null
        );
    }
}
