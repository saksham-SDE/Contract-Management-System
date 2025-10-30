package com.demo.utility;

import com.demo.DTO.WorkOrder;
import com.demo.DTO.Contract;
import com.demo.DTO.Contractor;
import com.demo.VO.WorkOrderVo;

public class WorkOrderMapper {

    public static WorkOrderVo mapWorkOrderToVo(WorkOrder w, Contract contract, Contractor contractor) {
        return new WorkOrderVo(
                w.getWId(),
                contract != null ? contract.getProject_name() : null,
                w.getWIssuedDate(),
                w.getWStatus(),
                w.getWCost(),
                w.getContractorId(),
                contractor != null ? contractor.getName() : null
        );
    }
}
