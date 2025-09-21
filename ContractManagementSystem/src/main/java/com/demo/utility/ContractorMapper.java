package com.demo.utility;

import com.demo.DTO.Contractor;
import com.demo.VO.ContractorVo;

public class ContractorMapper {

    public static ContractorVo mapToVo(Contractor contractor) {
        return new ContractorVo(
                contractor.getContractor_id(),
                contractor.getName(),
                contractor.getEmail(),
                contractor.getContact_no(),
                contractor.getAddress(),
                contractor.getLicense_no(),
                contractor.getRegister_date()
        );
    }

    public static Contractor mapToEntity(ContractorVo vo) {
        Contractor contractor = new Contractor();
        contractor.setContractor_id(vo.getContractor_id());
        contractor.setName(vo.getName());
        contractor.setEmail(vo.getEmail());
        contractor.setContact_no(vo.getContact_no());
        contractor.setAddress(vo.getAddress());
        contractor.setLicense_no(vo.getLicense_no());
        contractor.setRegister_date(vo.getRegister_date());
        return contractor;
    }
}

