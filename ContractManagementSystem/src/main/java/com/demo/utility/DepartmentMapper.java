package com.demo.utility;
import com.demo.DTO.Department;
import com.demo.VO.DepartmentVo;

public class DepartmentMapper {

    public static DepartmentVo mapToVo(Department department) {
        if (department == null) return null;
        return new DepartmentVo(
                department.getDep_id(),
                department.getDep_name(),
                department.getDescription(),
                department.getDep_address()
        );
    }

    public static Department mapToEntity(DepartmentVo vo) {
        if (vo == null) return null;
        Department department = new Department();
        department.setDep_id(vo.getDep_id());
        department.setDep_name(vo.getDep_name());
        department.setDescription(vo.getDescription());
        department.setDep_address(vo.getDep_address());
        return department;
    }
}

