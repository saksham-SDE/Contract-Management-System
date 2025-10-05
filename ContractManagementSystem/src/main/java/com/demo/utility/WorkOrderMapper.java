package com.demo.utility;

import com.demo.DTO.WorkOrder;
import com.demo.DTO.Contract;
import com.demo.DTO.Contractor;
import com.demo.VO.WorkOrderVo;

public class WorkOrderMapper {

    public static WorkOrderVo mapWorkOrderToVo(WorkOrder w, Contract contract, Contractor contractor) {
        return new WorkOrderVo(
                w.getW_id(),
                contract != null ? contract.getProject_name() : null, // map project_name
                w.getW_issued_date(),
                w.getW_status(),
                w.getW_cost(),
                w.getContractor_id(),
                contractor != null ? contractor.getName() : null
        );
    }
}
